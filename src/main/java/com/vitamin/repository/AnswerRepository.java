package com.vitamin.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vitamin.entity.Answer;
import com.vitamin.entity.Ingredient;

public interface AnswerRepository  extends CrudRepository<Answer, Integer> {

	Collection<Answer> findById(Integer integer);
	
	@Query("select ingredients from Answer a where a.id = :id")
	Collection<Ingredient> getIngredientsByAnswerId(@Param("id") Integer answerId);

}
