package com.vitamin.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitamin.entity.Category;
import com.vitamin.service.CategoryService;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@GetMapping("/fetchAllCategories")
	public ResponseEntity<Collection<Category>> fetchAllCategories(){
		return ResponseEntity.ok().body(service.fetchAllCategories());
	}
	
}
