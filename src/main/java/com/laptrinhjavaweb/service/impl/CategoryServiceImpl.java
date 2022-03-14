package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public CategoryEntity findOne(Long id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public CategoryEntity findOneByName(String name) {
		return categoryRepository.findOneByName(name);
	}

	@Override
	public List<CategoryEntity> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public CategoryEntity save(CategoryEntity category) {
		return categoryRepository.save(category);
	}

	@Override
	public void delete(CategoryEntity category) {
		categoryRepository.delete(category);
	}

}
