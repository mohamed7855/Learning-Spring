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
			
			Instructor tempInstructor = new Instructor("Salem", "Omara", "Omara@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("Youtube.com", "Tennis");
			Course tempCourse1 = new Course("Java");
			Course tempCourse2 = new Course("Spring");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			tempCourse1.setInstructor(tempInstructor);
			tempCourse2.setInstructor(tempInstructor);
			
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
						
			session.save(tempInstructor);
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
