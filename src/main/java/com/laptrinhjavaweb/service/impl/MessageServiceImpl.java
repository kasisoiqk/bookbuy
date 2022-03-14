package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.MessageEntity;
import com.laptrinhjavaweb.repository.MessageRepository;
import com.laptrinhjavaweb.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {
	
	@Autowired
	private MessageRepository messageRepository;

	@Override
	public MessageEntity save(MessageEntity messageEntity) {
		return messageRepository.save(messageEntity);
	}

	@Override
	public List<MessageEntity> getMessage(Long senderId, Long recipientId) {
		return messageRepository.getMessage(senderId, recipientId);
	}

}
