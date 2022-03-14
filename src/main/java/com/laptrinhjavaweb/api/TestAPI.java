package com.laptrinhjavaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;

@RestController(value = "testAPI")
@RequestMapping("/api")
public class TestAPI {
	@Autowired
	private UserRepository userService;
	@PostMapping("/test")
	public ResponseEntity<?> test(@RequestBody UserEntity userEntity) {
		return ResponseEntity.ok(userService.save(userEntity));
	}
}
