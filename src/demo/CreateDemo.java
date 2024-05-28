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

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			Course tempCourse = new Course("CSS");
			Review tempReview1 = new Review("Good");
			Review tempReview2 = new Review("Very Good");
			
			tempCourse.add(tempReview1);
			tempCourse.add(tempReview2);
			
			System.out.println("Saving the Course "+tempCourse.toString());
			System.out.println("Reviews: "+tempCourse.getReviews().toString());
			session.save(tempCourse);
			
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
