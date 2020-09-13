package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {

			// create the objects
			Instructor instructor = new Instructor("Sam", "Smith", "smith@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "music");
			
			// associate the objects
			instructor.setInstructorDetailId(instructorDetail);
			
			// start a transaction
			session.beginTransaction();

			// save the instructor
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			sessionFactory.close();
		}

	}

}
