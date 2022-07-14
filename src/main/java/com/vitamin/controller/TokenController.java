package com.vitamin.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitamin.security.JwtGenerator;
import com.vitamin.security.JwtUser;

@CrossOrigin
@RestController
@RequestMapping("/token")
public class TokenController {

	
	private JwtGenerator jwtGenerator;
	
	public TokenController(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}
	
	@PostMapping
	public String generate(@RequestBody final JwtUser jwtUser){
		jwtGenerator = new JwtGenerator();
		
		return jwtGenerator.generate(jwtUser);
	}
	
}
