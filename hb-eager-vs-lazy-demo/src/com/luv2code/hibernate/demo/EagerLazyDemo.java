package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			// option 1: call get method while session is open

			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("luv2code: instructor: " + instructor);
			System.out.println("luv2code: Courses: " + instructor.getCourses());
						
			// commit transaction
			session.getTransaction().commit();
			
			// close session
			session.close();
			
			// get course for the instructor
			System.out.println("luv2code: Courses: " + instructor.getCourses());

			System.out.println("luv2code: Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
