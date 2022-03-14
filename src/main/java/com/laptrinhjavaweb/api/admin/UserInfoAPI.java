package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.dto.response.ResponseMessage;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.SecurityUtils;

@RestController(value = "userInfoAPIOfAdmin")
@RequestMapping(value = {"/admin/api"})
public class UserInfoAPI {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	@PostMapping(value = {"/user"})
	public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
		if(SecurityUtils.isAuthentication()) {
			if(SecurityUtils.isADMIN()) {
				userDTO.setPassword(SecurityUtils.encodeMD5(userDTO.getPassword()));
				UserEntity userEntity = userMapper.convertToEntity(userDTO);
				return (userService.save(userEntity) != null) ?  
						ResponseEntity.status(HttpStatus.OK).body(
							new ResponseMessage("OK", "User has already been created!", "success")
						) : 
						ResponseEntity.status(HttpStatus.OK).body(
								new ResponseMessage("FAILED", "An error occurred!", "error")
							);
			}
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseMessage("FAILED", "You are not admin!", "not authen")
				);
		}
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseMessage("FAILED", "You are not logged in!", "not author")
			);
	}
	
	@PutMapping(value = {"/user"})
	public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO) {
		if(SecurityUtils.isAuthentication()) {
			if(SecurityUtils.isADMIN()) {
				UserEntity userEntity = userService.findOne(userDTO.getId());
				String password = userEntity.getPassword();
				userEntity = userMapper.convertToEntity(userDTO);
				userEntity.setPassword(password);
				return (userService.save(userEntity) != null) ?  
						ResponseEntity.status(HttpStatus.OK).body(
							new ResponseMessage("OK", "User has already been created!", "success")
						) : 
						ResponseEntity.status(HttpStatus.OK).body(
								new ResponseMessage("FAILED", "An error occurred!", "error")
							);
			}
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseMessage("FAILED", "You are not admin!", "not authen")
				);
		}
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseMessage("FAILED", "You are not logged in!", "not author")
			);
	}
	
	@DeleteMapping(value = {"/user"})
	public ResponseEntity<?> deleteUser(@RequestBody UserDTO userDTO) {
		if(SecurityUtils.isAuthentication()) {
			if(SecurityUtils.isADMIN()) {
				UserEntity userEntity = userService.findOne(userDTO.getId());
				userService.delete(userEntity);
				return ResponseEntity.status(HttpStatus.OK).body(
							new ResponseMessage("OK", "User has already been created!", "success")
						);
			}
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseMessage("FAILED", "You are not admin!", "not authen")
				);
		}
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseMessage("FAILED", "You are not logged in!", "not author")
			);
	}

}
