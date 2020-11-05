package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortuneService() {
		
		// simulate delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "Expect heavy traffic this morning!";
	}

	public String getFortuneService(boolean exceptionFlag) {

		if(exceptionFlag) {
			throw new RuntimeException("Highway is closed!");
		}
		
		return getFortuneService();
	}
}
