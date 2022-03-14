package com.laptrinhjavaweb.dto.response;

public class ResponseMessage {
	private String type;
	private String message;
	private Object data;
	public ResponseMessage() {
		super();
	}
	public ResponseMessage(String type, String message, Object data) {
		super();
		this.type = type;
		this.message = message;
		this.data = data;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
