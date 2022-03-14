package com.laptrinhjavaweb.api.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.BookDTO;
import com.laptrinhjavaweb.dto.response.ResponseMessage;
import com.laptrinhjavaweb.entity.BookEntity;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.mapper.BookMapper;
import com.laptrinhjavaweb.service.IBookService;
import com.laptrinhjavaweb.service.ICategoryService;

@RestController(value = "bookAPI")
@RequestMapping("/api")
public class BookAPI {
	
	@Autowired
	private IBookService bookService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private BookMapper bookMapper;
	
	@GetMapping(value = {"/book"})
	public ResponseEntity<?> getBook(@RequestParam(required = false, defaultValue = "0", value = "id") Long id) {
		BookEntity book = bookService.findOne(id);
		return (book != null) ? 
				ResponseEntity.ok(new ResponseMessage(
						"OK", 
						"Data book id " + id + " has already taken!", 
						bookMapper.convertToDTO(book)
						)) :
				ResponseEntity.ok(new ResponseMessage(
						"FAILED", 
						"Data book id " + id + " don't found in DB!", 
						null
						));
	}
	
	@GetMapping(value = {"/list-books"})
	public ResponseEntity<?> getListBooks(@RequestParam(required = false, defaultValue = "1", value = "page") int page,
			@RequestParam(required = false, defaultValue = "20", value = "size") int size,
			@RequestParam(required = false, defaultValue = "", value = "search") String search,
			@RequestParam(required = false, defaultValue = "0", value = "cate") long cate) {
		List<BookDTO> result = new ArrayList<>();
		Pageable pageable = new PageRequest(page-1, size);
		if(cate == 0) {
			if(search.equals("")) {
				for (BookEntity book : bookService.findAllByOrderByIdDesc(pageable)) {
					result.add(bookMapper.convertToDTO(book));
				}
			}
			else {
				for (BookEntity book : bookService.findAllByNameContainingOrderByIdDesc(search, pageable)) {
					result.add(bookMapper.convertToDTO(book));
				}
			}
		}
		else {
			CategoryEntity category = categoryService.findOne(cate);
			for (BookEntity book : bookService.findAllByNameContainingAndCategoryOrderByIdDesc(search, category, pageable)) {
				result.add(bookMapper.convertToDTO(book));
			}
		}
		return result.isEmpty() ?
				ResponseEntity.ok(new ResponseMessage("OK", "Data books is empty!", result)) :
				ResponseEntity.ok(new ResponseMessage("OK", "Data books has already taken!", result));
	}
	
	@GetMapping(value = {"/number-books"})
	public ResponseEntity<?> getNumberBooks(@RequestParam(required = false, defaultValue = "", value = "search") String search,
			@RequestParam(required = false, defaultValue = "0", value = "cate") long cate) {
		if(cate == 0) {
			if(search.equals("")) {
				return ResponseEntity.ok(
						new ResponseMessage("OK", "Number book has taken!", bookService.count())
						);
			}
			else {
				return ResponseEntity.ok(
						new ResponseMessage(
							"OK", 
							"Number book has taken!", 
							bookService.countByNameContaining(search)
						)
					);
			}
		}
		else {
			CategoryEntity category = categoryService.findOne(cate);
			return ResponseEntity.ok(
					new ResponseMessage(
						"OK", 
						"Number book has taken!", 
						bookService.countByNameContainingAndCategory(search, category)
					)
				);
		}
	}

}
