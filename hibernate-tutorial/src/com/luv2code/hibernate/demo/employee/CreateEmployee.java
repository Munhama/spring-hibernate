package com.luv2code.hibernate.demo.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployee {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("employee-hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			Employee employee = new Employee("Stan", "Johnson", "Microsoft");
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}

	}

}
