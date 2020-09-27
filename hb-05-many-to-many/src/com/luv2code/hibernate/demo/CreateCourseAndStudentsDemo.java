package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			Course course = new Course("Guitar - it`s easy");

			System.out.println("\nSaving the course");
			session.save(course);
			System.out.println("\nSaved the course: " + course);

			Student student1 = new Student("Stan", "Soul", "ss@gmail.com");
			Student student2 = new Student("Sam", "Potter", "potter@gmail.com");

			course.addStudent(student1);
			course.addStudent(student2);
			
			System.out.println("\nSaving students");
			session.save(student1);
			session.save(student2);
			System.out.println("\nSaved students: " + course.getStudents());

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
