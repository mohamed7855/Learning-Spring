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
			
			Course tempCourse = new Course("SQL");
			
			System.out.println("Saving Course "+tempCourse);
			session.save(tempCourse);
			
			Student tempStudent1 = new Student("Ali","Omara","Ali@gmail.com");
			Student tempStudent2 = new Student("Salem","Omara","Salem@gmail.com");
			
			tempCourse.add(tempStudent1);
			tempCourse.add(tempStudent2);
			System.out.println("Saving Course Students "+tempCourse.getStudents());
			session.save(tempStudent1);
			session.save(tempStudent2);
			
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
