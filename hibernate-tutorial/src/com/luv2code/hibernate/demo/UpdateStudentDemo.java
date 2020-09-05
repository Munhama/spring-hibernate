package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
						
			int studentId = 1;
		
			// get a new session and start transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			Student student = session.get(Student.class, studentId);
			System.out.println("Updating student");
			
			// update student first name
			student.setFirstName("Ozzy");
			
			// commit the transaction
			session.getTransaction().commit();
			
			// new transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all student
			System.out.println("Update email for all students");
			session.createQuery("update Student set email='foo@outlook.com'").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			sessionFactory.close();
		}
		
	}

}
