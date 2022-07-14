package com.vitamin.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vitamin.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
	
	@Query("select case when (count(c) > 0)then true else false end from Category c where c.id = :categoryId")
	public boolean validateCategoryId(@Param("categoryId") Integer categoryId);
	
	public Category findById(Integer id);
	
	
}
