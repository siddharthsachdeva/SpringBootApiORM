package com.vitamin.repository;

import org.springframework.data.repository.CrudRepository;

import com.vitamin.entity.Answer;
import com.vitamin.entity.NextQuestion;

public interface NextQuestionRepository  extends CrudRepository<NextQuestion, Integer> {

}
