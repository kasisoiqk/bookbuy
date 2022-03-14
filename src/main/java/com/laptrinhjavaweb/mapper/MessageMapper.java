package com.laptrinhjavaweb.mapper;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.MessageDTO;
import com.laptrinhjavaweb.entity.MessageEntity;

@Component
public class MessageMapper {

	public MessageDTO convertToDTO(MessageEntity messageEntity) {
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setId(messageEntity.getId());
		messageDTO.setSenderId(messageEntity.getSenderId());
		messageDTO.setRecipientId(messageEntity.getRecipientId());
		messageDTO.setContent(messageEntity.getContent());
		return messageDTO;
	}
	
	public MessageEntity convertToEntity(MessageDTO messageDTO) {
		MessageEntity messageEntity = new MessageEntity();
		messageEntity.setId(messageDTO.getId());
		messageEntity.setSenderId(messageDTO.getSenderId());
		messageEntity.setRecipientId(messageDTO.getRecipientId());
		messageEntity.setContent(messageDTO.getContent());
		return messageEntity;
	}
	
}
