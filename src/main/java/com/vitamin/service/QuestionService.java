package com.vitamin.service;

import java.util.Collection;

import com.vitamin.dto.OoviResponse;
import com.vitamin.entity.Question;

public interface QuestionService {
	
	Collection<Question> fetchAllQuestions();
	OoviResponse addQuestions(Collection<Question> questions);
	
	

}
