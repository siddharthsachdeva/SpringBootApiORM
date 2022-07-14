package com.vitamin.repository;

import org.springframework.data.repository.CrudRepository;

import com.vitamin.entity.Recommendation;

public interface RecommendationRepository extends CrudRepository<Recommendation, Integer> {
	
}
