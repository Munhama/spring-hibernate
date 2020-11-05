package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);

		System.out.println("\nMain Programm AroundDemoApp");
		System.out.println("---------------------------");
		System.out.println("Calling getFortuneService");
		
		System.out.println("FortuneService: " + trafficFortuneService.getFortuneService());

		System.out.println("Finish");
	
		// close the context
		context.close();

	}

}
