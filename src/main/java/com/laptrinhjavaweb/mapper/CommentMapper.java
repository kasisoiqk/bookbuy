package com.laptrinhjavaweb.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CommentDTO;
import com.laptrinhjavaweb.entity.CommentEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.BookRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.utils.FormatTimeUtils;

@Component
public class CommentMapper {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;

	public CommentDTO convertToDTO(CommentEntity commentEntity) {
		UserEntity userEntity = userRepository.findOne(commentEntity.getUserId());
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setId(commentEntity.getId());
		commentDTO.setBookId(commentEntity.getBook().getId());
		commentDTO.setUserId(commentEntity.getUserId());
		commentDTO.setFullName(userEntity.getFullName());
		commentDTO.setUserName(userEntity.getUserName());
		commentDTO.setContent(commentEntity.getContent());
		commentDTO.setTime(FormatTimeUtils.convertTime(commentEntity.getCreateDate()));
		return commentDTO;
	}
	
	public CommentEntity convertToEntity(CommentDTO commentDTO) {
		CommentEntity commentEntity = new CommentEntity();
		commentEntity.setId(commentDTO.getId());
		commentEntity.setUserId(commentDTO.getUserId());
		commentEntity.setBook(bookRepository.findOne(commentDTO.getBookId()));
		commentEntity.setContent(commentDTO.getContent());
		return commentEntity;
	}
	
}
