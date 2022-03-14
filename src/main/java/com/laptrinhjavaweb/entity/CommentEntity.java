package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity {
	
	@Column
	private Long userId;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "book_id", nullable = false)
	private BookEntity book;

	public CommentEntity() {
		super();
	}

	public CommentEntity(Long userId, String content, BookEntity book) {
		super();
		this.userId = userId;
		this.content = content;
		this.book = book;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BookEntity getBook() {
		return book;
	}

	public void setBook(BookEntity book) {
		this.book = book;
	}

}
