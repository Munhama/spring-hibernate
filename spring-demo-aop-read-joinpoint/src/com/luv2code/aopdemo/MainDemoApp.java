package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call the business method
		Account account = new Account();
		account.setName("John");
		account.setAge(28);
		
		accountDAO.addAccount(account, true);
		membershipDAO.addAccount();

		accountDAO.doWork();
		membershipDAO.goToSleep();

		// call the AccountDAO get/set methods
		accountDAO.setAge(1);
		accountDAO.setName("Sam");

		int age = accountDAO.getAge();
		String name = accountDAO.getName();
		System.out.println("\n\nAge: " + age + " Name: " + name);

		// close the context
		context.close();

	}

}
