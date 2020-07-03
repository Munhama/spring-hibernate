package com.luv2code.springdemo;

public class HockeyCoach implements Coach {

	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Skate 2 laps";
	}

	@Override
	public String getDailyFortune() {
		return "Just play hockey " + fortuneService.getFortune();
	}

}
