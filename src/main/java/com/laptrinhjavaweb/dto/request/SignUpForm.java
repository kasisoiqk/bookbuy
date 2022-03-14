package com.laptrinhjavaweb.dto.request;

public class SignUpForm {
	private String username;
	private String password;
	private String rePassword;
	public SignUpForm() {
		super();
	}
	public SignUpForm(String username, String password, String rePassword) {
		super();
		this.username = username;
		this.password = password;
		this.rePassword = rePassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
}
