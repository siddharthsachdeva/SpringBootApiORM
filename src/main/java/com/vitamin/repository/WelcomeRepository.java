package com.vitamin.repository;

import org.springframework.data.repository.CrudRepository;

import com.vitamin.entity.Welcome;

public interface WelcomeRepository extends CrudRepository<Welcome, Integer> {

}
