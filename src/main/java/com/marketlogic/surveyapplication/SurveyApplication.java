package com.marketlogic.surveyapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;


@SpringBootApplication
public class SurveyApplication {
	
	//Spring Boot Application Main Class 

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(SurveyApplication.class, args);
		
	}

}
