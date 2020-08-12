package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BestConfig {

	@Bean
	public FortuneService bestFortuneService() {
		return new BestFortuneService();
	}
	
	@Bean
	public Coach raceCoach(FortuneService bestFortuneService) {
		return new RaceCoach(bestFortuneService());
	}
}
