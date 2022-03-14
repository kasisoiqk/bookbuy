package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.response.ResponseMessage;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.utils.SecurityUtils;

@RestController(value = "categoryAPIOfAdmin")
@RequestMapping(value = {"/admin/api"})
public class CategoryAPI {
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@PostMapping(value = {"/category"})
	public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {
		if(SecurityUtils.isAuthentication()) {
			if(SecurityUtils.isADMIN()) {
				CategoryEntity categoryEntity = categoryMapper.convertToEntity(categoryDTO);
				categoryService.save(categoryEntity);
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseMessage("OK", "Comment has been created!", "success")
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
	
	@PutMapping(value = {"/category"})
	public ResponseEntity<?> updateCategory(@RequestBody CategoryDTO categoryDTO) {
		if(SecurityUtils.isAuthentication()) {
			if(SecurityUtils.isADMIN()) {
				CategoryEntity categoryEntity = categoryMapper.convertToEntity(categoryDTO);
				categoryService.save(categoryEntity);
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseMessage("OK", "Comment has been updated!", "success")
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
	
	@DeleteMapping(value = {"/category"})
	public ResponseEntity<?> deleteCategory(@RequestBody CategoryDTO categoryDTO) {
		if(SecurityUtils.isAuthentication()) {
			if(SecurityUtils.isADMIN()) {
				CategoryEntity categoryEntity = categoryMapper.convertToEntity(categoryDTO);
				categoryService.delete(categoryEntity);
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseMessage("OK", "Comment has been deleted!", "success")
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

}
