package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class MessageEntity extends BaseEntity {
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	@Column
	private Long senderId;
	
	@Column
	private Long recipientId;

	public MessageEntity() {
		super();
	}

	public MessageEntity(String content, Long senderId, Long recipientId) {
		super();
		this.content = content;
		this.senderId = senderId;
		this.recipientId = recipientId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(Long recipientId) {
		this.recipientId = recipientId;
	}

}
