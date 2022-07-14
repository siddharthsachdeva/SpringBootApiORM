package com.vitamin.service;

import java.util.Collection;

import com.vitamin.entity.Recommendation;
import com.vitamin.entity.UserAnswer;

public interface RecommendationService {

	Recommendation processUserRequest(Collection<UserAnswer> userAnswers);

}
