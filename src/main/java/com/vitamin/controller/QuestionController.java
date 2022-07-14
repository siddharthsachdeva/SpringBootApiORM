package com.vitamin.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitamin.dto.OoviResponse;
import com.vitamin.entity.Question;
import com.vitamin.service.QuestionService;

@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService service;
	
	@PostMapping("/addQuestions")
	public OoviResponse addQuestions(@RequestBody Collection<Question> questions){
		return service.addQuestions(questions);
	}
	
	@GetMapping("/fetchAllQuestions")
	public ResponseEntity<Object> fetchAllQuestions(){
		  return ResponseEntity.ok().body(service.fetchAllQuestions());
	}
}
