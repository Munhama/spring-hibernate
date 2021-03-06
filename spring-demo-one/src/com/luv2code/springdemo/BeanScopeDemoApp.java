package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("hockeyCoach", Coach.class);
		Coach secondCoach = context.getBean("hockeyCoach", Coach.class);
		
		// check if they are the same bean
		boolean result = (theCoach==secondCoach);
		
		// print result
		System.out.println("\nPointing to the same object: " + result);
		System.out.println("\nMemory location for theCoach: " + theCoach);
		System.out.println("\nMemory location for secondCoach: " + secondCoach + "\n");
		
		// close context
		context.close();
		
	}

}
