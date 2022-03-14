package com.laptrinhjavaweb.api.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.dto.response.ResponseMessage;
import com.laptrinhjavaweb.entity.BookEntity;
import com.laptrinhjavaweb.entity.CommentEntity;
import com.laptrinhjavaweb.mapper.CommentMapper;
import com.laptrinhjavaweb.service.IBookService;
import com.laptrinhjavaweb.service.ICommentService;
import com.laptrinhjavaweb.utils.SecurityUtils;

@RestController(value = "commentAPI")
@RequestMapping("/api")
public class CommentAPI {
	
	@Autowired
	private IBookService bookService;
	
	@Autowired
	private ICommentService commentService;
	
	@Autowired
	private CommentMapper commentMapper;
	
	@GetMapping(value = {"/list-comments"})
	public ResponseEntity<?> getListComments(@RequestParam(required = false, defaultValue = "0", value = "id") Long id) {
		List<CommentDTO> result = new ArrayList<>();
		BookEntity bookEntity = bookService.findOne(id);
		if(bookEntity != null) {
			List<CommentEntity> comments = commentService.findByBook(bookEntity);
			for (CommentEntity comment : comments) {
				result.add(commentMapper.convertToDTO(comment));
			}
		}
		return result.isEmpty() ? 
				ResponseEntity.ok(
						new ResponseMessage("OK", "Data comments is empty!", result)
					) :
				ResponseEntity.ok(
						new ResponseMessage("OK", "Data comments has already taken!", result)
					);
	}
	
	@PostMapping(value = {"/comment"})
	public ResponseEntity<?> sendComment(@RequestBody CommentDTO comment) {
		if(SecurityUtils.isAuthentication()) {
			if(SecurityUtils.getPrincipal().getId() == comment.getUserId()) {
				CommentEntity commentEntity = commentMapper.convertToEntity(comment);
				commentService.save(commentEntity);
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseMessage("OK", "Your comment has been received!", "success")
					);
			}
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseMessage("FAILED", "An error occurred!", "error")
				);
		}
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseMessage("FAILED", "You are not logged in!", "not auth")
			);
	}
	
	@DeleteMapping(value = {"/comment"})
	public ResponseEntity<?> deleteComment(@RequestBody CommentDTO comment) {
		if(SecurityUtils.isAuthentication()) {
			if(SecurityUtils.getPrincipal().getId() == comment.getUserId() || SecurityUtils.isADMIN()) {
				CommentEntity commentEntity = commentMapper.convertToEntity(comment);
				commentService.delete(commentEntity);
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseMessage("OK", "Comment has been deleted!", "success")
					);
			}
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseMessage("FAILED", "An error occurred!", "error")
				);
		}
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseMessage("FAILED", "You are not logged in!", "not auth")
			);
	}

}
