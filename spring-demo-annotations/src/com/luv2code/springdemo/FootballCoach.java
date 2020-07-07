package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

	@Override
	public String getDeilyWorkout() {
		return "Score 10 goals";
	}

}
