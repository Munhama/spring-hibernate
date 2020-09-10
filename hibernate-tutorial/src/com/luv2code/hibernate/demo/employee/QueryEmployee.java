package com.luv2code.hibernate.demo.employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryEmployee {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("employee-hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			List<Employee> employee = session.createQuery("from Employee").getResultList();
			displayEmployee(employee);
			
			employee = session.createQuery("from Employee where company='Apple'").getResultList();
			displayEmployee(employee);
			
		} finally {
			sessionFactory.close();
		}

	}

	private static void displayEmployee(List<Employee> employee) {
		for(Employee emp : employee) {
			System.out.println(emp);
		}
	}

}
