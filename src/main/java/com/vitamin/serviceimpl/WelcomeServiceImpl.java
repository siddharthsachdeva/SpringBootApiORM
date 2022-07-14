package com.vitamin.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitamin.entity.Welcome;
import com.vitamin.repository.WelcomeRepository;
import com.vitamin.service.WelcomeService;

@Service
public class WelcomeServiceImpl implements WelcomeService {
	
	private Welcome welcome = new Welcome("Welcome to Vitamin App");
	
	@Autowired
	WelcomeRepository repository;

	@Override
	public Welcome welcomeService() {
		if(!repository.findAll().iterator().hasNext()){
			repository.save(welcome);
		}
		return repository.findAll().iterator().next();
	}
	
	
}
