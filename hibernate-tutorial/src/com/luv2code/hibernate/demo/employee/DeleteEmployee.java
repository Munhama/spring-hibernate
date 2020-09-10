package com.luv2code.hibernate.demo.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee {

	public static void main(String[] args) {
		
		// object id to delete from DB
		int id = 2;
		
		SessionFactory sessionFactory = new Configuration()
				.configure("employee-hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Employee employee = session.get(Employee.class, id);
			
			session.delete(employee);
			
			session.getTransaction().commit();
			
		} finally {
			sessionFactory.close();
		}

	}

}
