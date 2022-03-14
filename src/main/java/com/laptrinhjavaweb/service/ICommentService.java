package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.entity.BookEntity;
import com.laptrinhjavaweb.entity.CommentEntity;

public interface ICommentService {
	List<CommentEntity> findByBook(BookEntity book);
	CommentEntity save(CommentEntity commentEntity);
	void delete(CommentEntity commentEntity);
}
