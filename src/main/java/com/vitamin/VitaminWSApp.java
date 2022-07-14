package com.vitamin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VitaminWSApp {
	
	public static void main(String[] args) {
		SpringApplication.run(VitaminWSApp.class, args);
	}
}

