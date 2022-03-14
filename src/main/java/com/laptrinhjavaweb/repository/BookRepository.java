package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.BookEntity;
import com.laptrinhjavaweb.entity.CategoryEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
	Page<BookEntity> findAllByOrderByIdDesc(Pageable pageable);
	Page<BookEntity> findAllByNameContainingOrderByIdDesc(String name, Pageable pageable);
	Page<BookEntity> findAllByNameContainingAndCategoryOrderByIdDesc(String name, CategoryEntity category, Pageable pageable);
	List<BookEntity> findAllByCategory(CategoryEntity category);
	Long countByNameContaining(String name);
	Long countByNameContainingAndCategory(String name, CategoryEntity category);
}
