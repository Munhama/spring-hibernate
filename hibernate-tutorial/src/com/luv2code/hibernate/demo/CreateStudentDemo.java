package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		String dateOfBirth = "01/01/1991";
		
		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
						
			Date date = DateUtils.parseDate(dateOfBirth);
			// create a student object
			System.out.println("Creating new student object");
			Student student = new Student("Sam", "Smith", "sam@gmail.com", date);
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Savig object");
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
		
			System.out.println("Done!");
			
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
		
	}

}
