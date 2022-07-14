package com.vitamin.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitamin.dto.LinkUnlinkIngredientDTO;
import com.vitamin.dto.OoviResponse;
import com.vitamin.entity.Ingredient;
import com.vitamin.service.AnswerService;

@CrossOrigin
@RestController
@RequestMapping("/answer")
public class AnswerController {
	
	@Autowired
	AnswerService service;
	
	@GetMapping("/fetchIngredientsByAnswerId/{id}")
	public Collection<Ingredient> fetchIngredientsByAnswerId(@PathVariable("id") Integer answerId){
		return service.fetchIngredientsByAnswerId(answerId);
	}
	
	@PostMapping("/unlinkIngredientFromAnswer/")
	public OoviResponse unlinkIngredientFromAnswer(@RequestBody LinkUnlinkIngredientDTO dto){
		System.out.println("API called");
		return service.unlinkIngredientFromAnswer(dto);
	}
	
	@PostMapping("/linkIngredientToAnswer/")
	public OoviResponse linkIngredientToAnswer(@RequestBody LinkUnlinkIngredientDTO dto){
		System.out.println("API called");
		return service.linkIngredientToAnswer(dto);
	}
}
