package com.vitamin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Admin_Details")
public class AdminDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ad_id_generator")
	@SequenceGenerator(name="ad_id_generator", sequenceName="ad_id_sequence", initialValue=1, allocationSize=1)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	public AdminDetails() {
		super();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
