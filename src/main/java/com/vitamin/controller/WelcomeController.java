package com.vitamin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitamin.entity.Welcome;
import com.vitamin.service.WelcomeService;

@CrossOrigin
@RestController
public class WelcomeController {
	
	@Autowired
	WelcomeService service;
	
	@RequestMapping("/welcome")
	public ResponseEntity<Welcome> welcome(){
		 return ResponseEntity.ok().body(service.welcomeService());
	}

}
