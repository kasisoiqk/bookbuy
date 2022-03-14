package com.laptrinhjavaweb.api.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.dto.response.ResponseMessage;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.SecurityUtils;

@RestController(value = "userAPI")
@RequestMapping("/api")
public class UserAPI {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	@PutMapping(value = {"/user"})
	public ResponseEntity<?> updateUser(@RequestBody UserDTO user) {
		if(SecurityUtils.isAuthentication()) {
			if(SecurityUtils.getPrincipal().getId() == user.getId()) {
				// Lấy ra thông tin user trong database
				UserEntity userEntity = userService.findOne(user.getId());
				// Lấy password và role
				String password = userEntity.getPassword();
				List<RoleEntity> roles = userEntity.getRoles();
				// Chuyển từ DTO sang Entity để lưu vào database
				userEntity = userMapper.convertToEntity(user);
				// Set password, role vừa lấy vào 
				userEntity.setPassword(password);
				userEntity.setRoles(roles);
				userService.save(userEntity);
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseMessage("OK", "Your info has been updated!", "success")
					);
			}
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseMessage("FAILED", "An error occurred!", "error")
				);
		}
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseMessage("FAILED", "You are not logged in!", "not auth")
			);
	}
}
