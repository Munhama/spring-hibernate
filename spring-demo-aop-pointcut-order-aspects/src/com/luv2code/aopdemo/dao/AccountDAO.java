package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private int age;

	public String getName() {
		System.out.println(getClass() + " getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " setName()");
		this.name = name;
	}

	public int getAge() {
		System.out.println(getClass() + " getAge()");
		return age;
	}

	public void setAge(int age) {
		System.out.println(getClass() + " setAge()");
		this.age = age;
	}

	public void addAccount(Account account, boolean flag) {

		System.out.println(getClass() + " Doing DB work: adding an account");
	}

	public boolean doWork() {

		System.out.println(getClass() + " doWork()");

		return true;
	}
}
