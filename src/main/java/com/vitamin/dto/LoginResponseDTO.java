package com.vitamin.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.vitamin.entity.AdminDetails;

@JsonInclude(Include.NON_NULL)
public class LoginResponseDTO {
	
	private String token;
	private AdminDetails admin;
	
	public LoginResponseDTO(String token, AdminDetails admin) {
		super();
		this.token = token;
		this.admin = admin;
	}
	public LoginResponseDTO() {
		
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public AdminDetails getAdmin() {
		return admin;
	}
	public void setCustomer(AdminDetails admin) {
		this.admin = admin;
	}
}
