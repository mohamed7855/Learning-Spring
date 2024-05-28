package demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import demo.entity.Review;
import demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			Student tempStudent = session.get(Student.class, 1);
			System.out.println("Loaded Student: "+tempStudent);
			System.out.println("Courses: "+tempStudent.getCourses());
			
			Course tempCourse1 = new Course("Angular");
			Course tempCourse2 = new Course("React");
			
			System.out.println("Adding More Courses...");
			tempStudent.add(tempCourse1);
			tempStudent.add(tempCourse2);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done! Now All Courses: "+tempStudent.getCourses());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}

	
}
