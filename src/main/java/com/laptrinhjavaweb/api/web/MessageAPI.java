package com.laptrinhjavaweb.api.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.MessageDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.dto.response.ResponseMessage;
import com.laptrinhjavaweb.entity.MessageEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.mapper.MessageMapper;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.service.IMessageService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.SecurityUtils;

@RestController(value = "messageAPI")
@RequestMapping("/api")
public class MessageAPI {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IMessageService messageService;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private MessageMapper messageMapper;
	
	@GetMapping(value = {"/list-users"})
	public ResponseEntity<?> getListUsers() {
		List<UserDTO> result = new ArrayList<>();
		if(SecurityUtils.isAuthentication()) {
			List<UserEntity> users = userService.findAll();
			for (UserEntity user : users) {
				result.add(userMapper.convertToDTO(user));
			}
			return result.isEmpty() ? 
					ResponseEntity.ok(
							new ResponseMessage("OK", "Data users is empty!", null)
						) :
					ResponseEntity.ok(
							new ResponseMessage("OK", "Data users has already taken!", result)
						);
		}
		return null;
	}
	
	@GetMapping(value = {"/message"})
	public ResponseEntity<?> getMessage(@RequestParam(required = false, defaultValue = "0", value = "senderId") Long senderId,
			@RequestParam(required = false, defaultValue = "0", value = "recipientId") Long recipientId) {
		List<MessageDTO> result = new ArrayList<>();
		if(SecurityUtils.isAuthentication()) {
			if(SecurityUtils.getPrincipal().getId() == senderId) {
				List<MessageEntity> messages = messageService.getMessage(senderId, recipientId);
				for (MessageEntity message : messages) {
					result.add(messageMapper.convertToDTO(message));
				}
				return result.isEmpty() ? 
						ResponseEntity.ok(
								new ResponseMessage("OK", "Data users is empty!", null)
							) :
						ResponseEntity.ok(
								new ResponseMessage("OK", "Data users has already taken!", result)
							);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseMessage("FAILED", "You are not logged in!", null)
			);
	}
	
	@PostMapping(value = {"/message"})
	public ResponseEntity<?> postMessage(@RequestBody MessageDTO messageDTO) {
		if(SecurityUtils.isAuthentication()) {
			if(SecurityUtils.getPrincipal().getId() == messageDTO.getSenderId()) {
				MessageEntity messageEntity = messageMapper.convertToEntity(messageDTO);
				messageService.save(messageEntity);
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseMessage("OK", "Your message has been send!", "success")
					);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseMessage("FAILED", "An error occurred. Your message has'n been send!", "success")
			);
	}

}
