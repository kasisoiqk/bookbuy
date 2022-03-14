package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.entity.CategoryEntity;

public interface ICategoryService {
	List<CategoryEntity> findAll();
	CategoryEntity findOne(Long id);
	CategoryEntity findOneByName(String name);
	CategoryEntity save(CategoryEntity category);
	void delete(CategoryEntity category);
}
