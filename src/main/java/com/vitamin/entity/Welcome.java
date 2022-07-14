package com.vitamin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Welcome")
public class Welcome {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="welcome_id_generator")
	@SequenceGenerator(name="welcome_id_generator", sequenceName="welcome_id_sequence", initialValue=1, allocationSize=1)
	@Column(name="id")
	Integer id;
	
	@Column(name = "message")
	private String message;

	public Welcome(){
		
	}
	
	public Welcome(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
