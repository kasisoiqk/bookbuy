package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.BookEntity;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.BookRepository;
import com.laptrinhjavaweb.service.IBookService;

@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookEntity findOne(Long id) {
		return bookRepository.findOne(id);
	}

	@Override
	public List<BookEntity> findAllByOrderByIdDesc(Pageable pageable) {
		return bookRepository.findAllByOrderByIdDesc(pageable).getContent();
	}

	@Override
	public List<BookEntity> findAllByNameContainingOrderByIdDesc(String name, Pageable pageable) {
		return bookRepository.findAllByNameContainingOrderByIdDesc(name, pageable).getContent();
	}

	@Override
	public List<BookEntity> findAllByNameContainingAndCategoryOrderByIdDesc(String name, CategoryEntity category,
			Pageable pageable) {
		return bookRepository.findAllByNameContainingAndCategoryOrderByIdDesc(name, category, pageable).getContent();
	}

	@Override
	public List<BookEntity> findAllByCategory(CategoryEntity category) {
		return bookRepository.findAllByCategory(category);
	}

	@Override
	public Long countByNameContaining(String name) {
		return bookRepository.countByNameContaining(name);
	}

	@Override
	public Long countByNameContainingAndCategory(String name, CategoryEntity category) {
		return bookRepository.countByNameContainingAndCategory(name, category);
	}

	@Override
	public Long count() {
		return bookRepository.count();
	}

	@Override
	public BookEntity save(BookEntity bookEntity) {
		return bookRepository.save(bookEntity);
	}

	@Override
	public void delete(BookEntity bookEntity) {
		bookRepository.delete(bookEntity);
	}

}
