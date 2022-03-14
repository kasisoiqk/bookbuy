package com.laptrinhjavaweb.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.BookDTO;
import com.laptrinhjavaweb.entity.BookEntity;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.CommentEntity;
import com.laptrinhjavaweb.repository.BookRepository;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.CommentRepository;

@Component
public class BookMapper {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CommentRepository commentRepository;

	public BookDTO convertToDTO(BookEntity bookEntity) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(bookEntity.getId());
		bookDTO.setName(bookEntity.getName());
		bookDTO.setAuthor(bookEntity.getAuthor());
		bookDTO.setCurrentPrice(bookEntity.getCurrentPrice());
		bookDTO.setOldPrice(bookEntity.getOldPrice());
		bookDTO.setSale(bookEntity.getSale());
		bookDTO.setDescription(bookEntity.getDescription());
		bookDTO.setCateName(bookEntity.getCategory().getName());
		bookDTO.setQuantity(bookEntity.getQuantity());
		bookDTO.setImage(bookEntity.getImage());
		return bookDTO;
	}
	
	public BookEntity convertToEntity(BookDTO bookDTO) {
		BookEntity bookEntity = new BookEntity();
		CategoryEntity cate = categoryRepository.findOneByName(bookDTO.getCateName());
		bookEntity.setId(bookDTO.getId());
		bookEntity.setCategory(cate);
		bookEntity.setName(bookDTO.getName());
		bookEntity.setAuthor(bookDTO.getAuthor());
		bookEntity.setCurrentPrice(bookDTO.getCurrentPrice());
		bookEntity.setOldPrice(bookDTO.getOldPrice());
		bookEntity.setDescription(bookDTO.getDescription());
		bookEntity.setImage(bookDTO.getImage());
		bookEntity.setSale(bookDTO.getSale());
		bookEntity.setQuantity(bookDTO.getQuantity());
		List<CommentEntity> commentEntities = commentRepository.findByBook(bookRepository.findOne(bookDTO.getId()));
		bookEntity.setComments(commentEntities);
		return bookEntity;
	}
	
}
