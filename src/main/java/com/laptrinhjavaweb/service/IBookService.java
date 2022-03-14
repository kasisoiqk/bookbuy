package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.entity.BookEntity;
import com.laptrinhjavaweb.entity.CategoryEntity;

public interface IBookService {
	BookEntity findOne(Long id);
	List<BookEntity> findAllByOrderByIdDesc(Pageable pageable);
	List<BookEntity> findAllByNameContainingOrderByIdDesc(String name, Pageable pageable);
	List<BookEntity> findAllByNameContainingAndCategoryOrderByIdDesc(String name, CategoryEntity category, Pageable pageable);
	List<BookEntity> findAllByCategory(CategoryEntity category);
	Long countByNameContaining(String name);
	Long countByNameContainingAndCategory(String name, CategoryEntity category);
	Long count();
	BookEntity save(BookEntity bookEntity);
	void delete(BookEntity bookEntity);
}
