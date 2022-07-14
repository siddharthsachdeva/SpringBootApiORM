package com.vitamin.security;

public class JwtUser {
	
	private int id;
	private String username;
	private String role;

	public JwtUser() {
		super();
	}

	public JwtUser(int id, String username, String role) {
		super();
		this.username = username;
		this.id = id;
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public int getId() {
		return id;
	}

	public String getRole() {
		return role;
	}
}
