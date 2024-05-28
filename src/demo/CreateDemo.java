package demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
			
			// Option(2): using (HQL) Hibernate Query Language
			int theId = 5;
			Query<Instructor> query = session.createQuery("select i from Instructor i "
										+"JOIN FETCH i.courses " 
										+"where i.id=:theInstructorId",
								Instructor.class);
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// execute query
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("instructor: "+tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
			// close the session 
			session.close();
			System.out.println("instructor: "+tempInstructor.getCourses());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}

	
}
