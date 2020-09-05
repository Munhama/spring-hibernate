package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			System.out.println();
			// query students
			List<Student> students = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(students);
			
			System.out.println();
			// query students: lastName = 'Smith'
			students = session.createQuery("from Student s where s.lastName='Smith'").getResultList();
			
			// display the students
			System.out.println("Students with last name Smith");
			displayStudents(students);
			
			System.out.println();
			// query students: lastName = 'Smith' OR firstName = 'Bruno'
			students = session.createQuery("from Student s where s.lastName='Smith' OR s.firstName='Bruno'").getResultList();
			
			// display the students
			System.out.println("Students with last name Smith OR first name Bruno");
			displayStudents(students);
			
			System.out.println();
			// query students: email LIKE '%m%@gmail.com'
			students = session.createQuery("from Student s where s.email"
											+ " LIKE '%m%@gmail.com'").getResultList();
			
			// display the students
			System.out.println("Students with email LIKE '%m%@gmail.com'");
			displayStudents(students);
			
			// commit transaction
			session.getTransaction().commit();
		
			System.out.println("Done!");
			
		} finally {
			sessionFactory.close();
		}
		
	}

	private static void displayStudents(List<Student> students) {
		for (Student tempStudent : students) {
			System.out.println(tempStudent);
		}
	}

}
