package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Account> findAccounts() {
		
		List<Account> listAccount = new ArrayList<>();
		
		// create sample account
		Account account1 = new Account("Sam", 10);
		Account account2 = new Account("Bob", 30);
		Account account3 = new Account("Stan", 77);
		
		// add them to accounts list
		listAccount.add(account1);
		listAccount.add(account2);
		listAccount.add(account3);
		
		return listAccount;
	}
}
