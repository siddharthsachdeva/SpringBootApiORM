package com.vitamin.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitamin.entity.Recommendation;
import com.vitamin.entity.UserAnswer;
import com.vitamin.service.RecommendationService;

@CrossOrigin
@RestController
@RequestMapping("/recommendation")
public class RecommendationController {
	
	@Autowired
	private RecommendationService service;
	
	@PostMapping("/processUserRequest")
	public Recommendation processUserRequest(@RequestBody Collection<UserAnswer> userAnswers){
		return service.processUserRequest(userAnswers);
	}

}
