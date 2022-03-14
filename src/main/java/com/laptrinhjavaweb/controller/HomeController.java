package com.laptrinhjavaweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.SecurityUtils;

@Controller(value = "controllerOfLoginSignup")
public class HomeController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public ModelAndView loadLoginPage() {
		return new ModelAndView("login/login");
	}
	
	@RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
	public ModelAndView loadSignupPage() {
		return new ModelAndView("login/signup");
	}
	
	@RequestMapping(value = {"/change-password"}, method = RequestMethod.GET)
	public ModelAndView loadChangePasswordPage() {
		return new ModelAndView("login/change-password");
	}
	
	@RequestMapping(value = {"/change-password"}, method = RequestMethod.POST)
	public ModelAndView changePassword(
			@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "password", required = true) String password,
			@RequestParam(name = "new-password", required = true) String newPassword,
			@RequestParam(name = "re-password", required = true) String rePassword) {
//		username = username.trim(); password = password.trim(); newPassword = newPassword.trim(); rePassword = rePassword.trim();
		UserEntity userEntity = userService.findOneByUserName(username);
		if(userEntity == null) {
			return new ModelAndView("redirect:/change-password?incorrectAccount");
		}
		if(!SecurityUtils.verifyMD5(password, userEntity.getPassword())) {
			return new ModelAndView("redirect:/change-password?incorrectAccount");
		}
		if(newPassword.length() < 6) {
			return new ModelAndView("redirect:/change-password?invalidPassword");
		}
		if(!newPassword.equals(rePassword)) {
			return new ModelAndView("redirect:/change-password?incorectRepassword");
		}
		userEntity.setPassword(SecurityUtils.encodeMD5(newPassword));
		userService.save(userEntity);
		return new ModelAndView("redirect:/change-password?changePasswordSuccess");
	}
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/home");
	}
}
