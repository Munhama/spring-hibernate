package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// define default constructor
	public TennisCoach() {
		System.out.println("Inside default constructor\n");
	}
	
	// define my init method
	@PostConstruct
	public void startupMethod() {
		System.out.println("Inside init method\n");
	}
	
	// define my destroy method
	@PreDestroy
	public void cleanupMethod() {
		System.out.println("Inside destroy method\n");
	}
	
	// define a setter method
	// rename a setter method on any name
	/*@Autowired
	public void anyFortune(FortuneService fortuneService) {
		System.out.println("Inside a any method");
		this.fortuneService = fortuneService;
	}
	*/
	/*
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService; 
	}
	*/
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
