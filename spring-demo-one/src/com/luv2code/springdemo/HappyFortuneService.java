package com.luv2code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

	// create array random string
	private String[] fortune = {
			"Your lucky!",
			"Your unlucky!",
			"I don't know"
	};
	
	// create random number generator
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		int index = random.nextInt(3);
		return fortune[index];
	}

}
