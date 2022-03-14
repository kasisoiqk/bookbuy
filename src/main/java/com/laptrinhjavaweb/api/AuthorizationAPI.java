package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.request.SignUpForm;
import com.laptrinhjavaweb.dto.response.ResponseMessage;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.SecurityUtils;

@RestController(value = "authorization")
@RequestMapping("/api")
public class AuthorizationAPI {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping(value = {"/authorization"})
	public ResponseEntity<?> authorization() {
		if(SecurityUtils.isAuthentication()) {
			List<String> roles = SecurityUtils.getAuthorities();
			if(roles.contains("ADMIN")) {
				return ResponseEntity.ok(
						new ResponseMessage("OK", "You are admin!", "ADMIN")
					);
			}
			else if(roles.contains("USER")) {
				return ResponseEntity.ok(
						new ResponseMessage("OK", "You are user!", "USER")
					);
			}
		}
		return ResponseEntity.ok(
				new ResponseMessage("OK", "You are not sign in!", "NOT AUTHENTICATE")
			);
	}
	
	@GetMapping(value = {"/current-account"})
	public ResponseEntity<?> currentAccount() {
		if(SecurityUtils.isAuthentication()) {
			UserEntity userEntity = userService.findOne(SecurityUtils.getPrincipal().getId());
			return ResponseEntity.ok(
					new ResponseMessage(
							"OK", 
							"Your account information has taken!", 
							userMapper.convertToDTO(userEntity)
						)
				);
		}
		return ResponseEntity.ok(
				new ResponseMessage(
						"FAILED", 
						"You are not logged in!", 
						null
					)
			);
	}
	
	@RequestMapping(value = {"/create-user"}, method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody SignUpForm signUpForm) {
		if(userService.existsByUserName(signUpForm.getUsername())) {
			return ResponseEntity.ok(
					new ResponseMessage("OK", "Your username input had!", "hadUsername")
				);
		}
		if(signUpForm.getUsername().length() < 6) {
			return ResponseEntity.ok(
					new ResponseMessage("OK", "Your username input invalid!", "invalidUsername")
				);
		}
		if(signUpForm.getPassword().length() < 6) {
			return ResponseEntity.ok(
					new ResponseMessage("OK", "Your password input invalid!", "invalidPassword")
				);
		}
		if(!signUpForm.getPassword().equals(signUpForm.getRePassword())) {
			return ResponseEntity.ok(
					new ResponseMessage("OK", "Repassword is incorrect!", "incorectRepassword")
				);
		}
		userService.registerNewUser(signUpForm.getUsername(), signUpForm.getPassword());
		return ResponseEntity.ok(
				new ResponseMessage("OK", "You are signup account success!", "signupSuccess")
			);
	}

}
