package demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// get a course 
			Course tempCourse = session.get(Course.class, 12);
			// delete a course
			session.delete(tempCourse);
			
			// commit transaction
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}

	
}
