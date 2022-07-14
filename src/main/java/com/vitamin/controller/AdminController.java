package com.vitamin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vitamin.dto.OoviResponse;
import com.vitamin.entity.AdminDetails;
import com.vitamin.service.AdminService;

@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	private AdminService service;
	
	@PostMapping("/admin/login/")
	public ResponseEntity<OoviResponse> login(@RequestBody AdminDetails adminDetails){
		return ResponseEntity.ok().body(service.loginUser(adminDetails));
	}
	
	@PostMapping("/secure/admin/addAdmin/")
	public ResponseEntity<OoviResponse> addAdmin(@RequestBody AdminDetails adminDetails){
		return ResponseEntity.ok().body(service.addAdmin(adminDetails));
	}
}
