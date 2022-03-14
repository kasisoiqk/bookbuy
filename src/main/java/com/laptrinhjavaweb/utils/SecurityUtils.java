package com.laptrinhjavaweb.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.laptrinhjavaweb.dto.MyUser;

public class SecurityUtils {
	
	public static boolean isAuthentication() {
		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(obj != "anonymousUser") {
			return true;
		}
		return false;
	}
	
	public static MyUser getPrincipal() {
		MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return myUser;
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities() {
		List<String> result = new ArrayList<>();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>)
				SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for(GrantedAuthority authority : authorities) {
			result.add(authority.getAuthority());
		}
		return result;
	}
	
	public static boolean isADMIN() {
		return getAuthorities().contains("ADMIN");
	}
	
	public static String encodeMD5(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
	}
	
	public static boolean verifyMD5(String inputPassword, String hashPassword) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(inputPassword, hashPassword);
	}

}
