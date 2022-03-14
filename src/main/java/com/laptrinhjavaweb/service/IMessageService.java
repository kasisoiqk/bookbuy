package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.entity.MessageEntity;

public interface IMessageService {
	MessageEntity save(MessageEntity messageEntity);
	List<MessageEntity> getMessage(Long senderId, Long recipientId);
}
