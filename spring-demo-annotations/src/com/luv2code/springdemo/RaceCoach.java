package com.luv2code.springdemo;

public class RaceCoach implements Coach {

	private FortuneService fortuneService;
	
	public RaceCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Drive 10 laps!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
