package com.vitamin.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitamin.dto.OoviResponse;
import com.vitamin.entity.Ingredient;
import com.vitamin.service.IngredientService;

@CrossOrigin
@RestController
@RequestMapping("/ingredient")
public class IngredientController {
	
	@Autowired
	private IngredientService service;
	
	@PostMapping(path="/addOrEditIngredient", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public OoviResponse addOrEditIngredient(@RequestParam("ingredientDetails") String ingredientDetails, @RequestParam("file") MultipartFile file) throws JsonParseException, JsonMappingException, IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		Ingredient ingredient = mapper.readValue(ingredientDetails, Ingredient.class);
		System.out.println("Okay API hit hui hain..."+ingredient.getIngredientName());
		
		return service.addOrEditIngredient(ingredient, file);
	}
	
	@PostMapping(path="/addOrEditIngredientWithoutFile")
	public OoviResponse addOrEditIngredientWithoutFile(@RequestParam("ingredientDetails") String ingredientDetails) throws JsonParseException, JsonMappingException, IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		Ingredient ingredient = mapper.readValue(ingredientDetails, Ingredient.class);
		System.out.println("Okay API hit hui hain..."+ingredient.getIngredientName());
		
		return service.addOrEditIngredient(ingredient, null);
	}
	
	@PostMapping("/linkIngredientsWithAnswers")
	public OoviResponse linkIngredientsWithAnswers(@RequestBody Collection<Map<String, Integer>> ingredientsAndAnswersMap){
		return service.linkIngredientsWithAnswers(ingredientsAndAnswersMap);
	}
	
	@GetMapping("/fetchAllIngredients")
	public ResponseEntity<Collection<Ingredient>> fetchAllIngredients(){
		return ResponseEntity.ok().body(service.fetchAllIngredients());
	}
	
	@DeleteMapping("/deleteIngredient/{id}")
	public OoviResponse deleteIngredient(@PathVariable Integer id){
		return service.deleteIngredient(id);
	}

}
