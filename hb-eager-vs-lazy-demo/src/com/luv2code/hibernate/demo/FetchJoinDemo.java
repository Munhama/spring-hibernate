package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			// option 2: Hibernate query with HQL

			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			int id = 1;

			Query<Instructor> query = session.createQuery(
					"select i from Instructor i JOIN FETCH i.courses where i.id=:instructorId", Instructor.class);
			query.setParameter("instructorId", id);
			
			// execute query and get instructor
			Instructor instructor = query.getSingleResult();

			System.out.println("luv2code: instructor: " + instructor);

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
