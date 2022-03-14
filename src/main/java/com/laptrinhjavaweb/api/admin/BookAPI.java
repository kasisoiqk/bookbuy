package com.laptrinhjavaweb.api.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.laptrinhjavaweb.dto.BookDTO;
import com.laptrinhjavaweb.dto.response.ResponseMessage;
import com.laptrinhjavaweb.entity.BookEntity;
import com.laptrinhjavaweb.mapper.BookMapper;
import com.laptrinhjavaweb.service.IBookService;
import com.laptrinhjavaweb.utils.SecurityUtils;

@RestController(value = "bookAPIOfAdmin")
@RequestMapping(value = {"/admin/api"})
public class BookAPI {

	@Autowired
	private IBookService bookService;
	
	@Autowired
	private BookMapper bookMapper;
	
	@PostMapping(value = {"/book"})
	public ResponseEntity<?> createBook(@RequestBody BookDTO bookDTO) {
		if(SecurityUtils.isAuthentication()) {
			if(SecurityUtils.isADMIN()) {
				try {
					BookEntity bookEntity = bookMapper.convertToEntity(bookDTO);
					bookEntity = bookService.save(bookEntity);
					return ResponseEntity.status(HttpStatus.OK).body(
							new ResponseMessage("OK", "Book has been created!", bookEntity.getId())
						);
				} catch (Exception e) {
					return ResponseEntity.status(HttpStatus.OK).body(
							new ResponseMessage("FAILED", "An error occurred!", "error")
						);
					}
				}
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseMessage("FAILED", "You are not admin!", "not authen")
					);
			}
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseMessage("FAILED", "You are not logged in!", "not author")
				);
	}
	
	@PutMapping(value = {"/book"})
	public ResponseEntity<?> updateBook(@RequestBody BookDTO bookDTO) {
		if(SecurityUtils.isAuthentication()) {
			if(SecurityUtils.isADMIN()) {
				try {
					BookEntity bookEntity = bookMapper.convertToEntity(bookDTO);
					bookEntity = bookService.save(bookEntity);
					return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseMessage("OK", "Book has been updated!", bookEntity.getId())
					);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseMessage("FAILED", "An error occurred!", "error")
					);
				}
			}
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseMessage("FAILED", "You are not admin!", "not authen")
				);
		}
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseMessage("FAILED", "You are not logged in!", "not author")
			);
	}
	
	@DeleteMapping(value = {"/book"})
	public ResponseEntity<?> deleteBook(@RequestBody BookDTO bookDTO) {
		if(SecurityUtils.isAuthentication()) {
			if(SecurityUtils.isADMIN()) {
				BookEntity bookEntity = bookMapper.convertToEntity(bookDTO);
				bookService.delete(bookEntity);
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseMessage("OK", "Book has been deleted!", bookEntity.getId())
					);
			}
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseMessage("FAILED", "You are not admin!", "not authen")
				);
		}
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseMessage("FAILED", "You are not logged in!", "not author")
			);
	}
	
	@RequestMapping(value = { "/upload/image" }, method = RequestMethod.POST)
	public ResponseEntity<?> saveImageUser(HttpSession session,
			@RequestParam(name = "id", required = true) Long id,
			@RequestParam(name = "book-img", required = true) CommonsMultipartFile file) throws IOException {
		
		if(!file.getOriginalFilename().equals("")) {
			// Save image
			ServletContext context = session.getServletContext();  
		    String path = context.getRealPath("/template/images/");
		    // file must be rename
            String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
            String generatedFileName = UUID.randomUUID().toString().replace("-", "");
            generatedFileName = generatedFileName + "." + fileExtension;
		  
		    byte[] bytes = file.getBytes();  
		    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
		         new File(path + File.separator + generatedFileName)));  
		    stream.write(bytes);  
		    stream.flush();  
		    stream.close();

		    BookEntity book = bookService.findOne(id);
		    book.setImage(generatedFileName);
		    bookService.save(book);
		    return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseMessage("OK", "Image has been send!", "success")
				);
		}
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseMessage("FAILED", "An error occurred!", "error")
			);
	}
	
}
