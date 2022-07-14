package com.vitamin.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Integer statusCode;
	private String message;
	
	public ServiceException(Integer statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatus(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
