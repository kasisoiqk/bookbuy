package com.laptrinhjavaweb.mapper;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;

@Component
public class CategoryMapper {

	public CategoryDTO convertToDTO(CategoryEntity categoryEntity) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(categoryEntity.getId());
		categoryDTO.setName(categoryEntity.getName());
		return categoryDTO;
	}
	
	public CategoryEntity convertToEntity(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setId(categoryDTO.getId());
		categoryEntity.setName(categoryDTO.getName());
		return categoryEntity;
	}
	
}
