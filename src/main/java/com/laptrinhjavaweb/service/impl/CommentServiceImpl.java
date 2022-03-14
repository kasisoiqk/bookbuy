package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.BookEntity;
import com.laptrinhjavaweb.entity.CommentEntity;
import com.laptrinhjavaweb.repository.CommentRepository;
import com.laptrinhjavaweb.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService {
	
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<CommentEntity> findByBook(BookEntity book) {
		return commentRepository.findByBook(book);
	}

	@Override
	public CommentEntity save(CommentEntity commentEntity) {
		return commentRepository.save(commentEntity);
	}

	@Override
	public void delete(CommentEntity commentEntity) {
		commentRepository.delete(commentEntity);;
	}

}
