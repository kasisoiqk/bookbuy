package com.laptrinhjavaweb.api.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.response.ResponseMessage;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.service.ICategoryService;

@RestController(value = "categoryAPI")
@RequestMapping("/api")
public class CategoryAPI {
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private CategoryMapper categoryMapper;

	@GetMapping(value = {"/list-categories"})
	public ResponseEntity<?> getListCategories() {
		List<CategoryDTO> result = new ArrayList<>();
		List<CategoryEntity> categories = categoryService.findAll();
		for (CategoryEntity category : categories) {
			result.add(categoryMapper.convertToDTO(category));
		}
		return result.isEmpty() ? 
				ResponseEntity.ok(
						new ResponseMessage("OK", "Data categories is empty!", null)
					) :
				ResponseEntity.ok(
						new ResponseMessage("OK", "Data categories has already taken!", result)
					);
	}
}
