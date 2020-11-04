package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addAccount() {
		
		System.out.println(getClass() + " Doing at adding");
		
		return true;
	}

	public void goToSleep() {

		System.out.println(getClass() + " goToSleep()");
	}
}
