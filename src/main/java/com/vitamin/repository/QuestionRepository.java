package com.vitamin.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.vitamin.entity.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
	
	public Collection<Question> findAllByOrderByIdAsc();

}
