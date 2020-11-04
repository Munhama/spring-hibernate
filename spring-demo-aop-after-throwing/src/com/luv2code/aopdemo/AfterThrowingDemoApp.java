package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call method to find the account
		List<Account> listAccount = null;

		try {
			// add a boolean flag to simulate exception
			boolean excFlag = true;
			
			listAccount = accountDAO.findAccounts(excFlag);
		} catch (Exception e) {
			System.out.println("Main Programm Exception: " + e);
		}

		// display the accounts
		System.out.println("\n\nMain Programm AfterThrowing");
		System.out.println("----------------------------");
		System.out.println(listAccount);

		// close the context
		context.close();

	}

}
