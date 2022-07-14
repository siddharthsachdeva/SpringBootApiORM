package com.vitamin.serviceimpl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitamin.entity.Category;
import com.vitamin.repository.CategoryRepository;
import com.vitamin.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository repository;

	@Override
	public Collection<Category> fetchAllCategories() {
		Collection<Category> categories = new ArrayList<>();
		try {
			repository.findAll().forEach(categories::add);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}
}
