package demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			System.out.println("\n\nAll Students...");
			displayStudents(theStudents);
			
			// query students: lastName='Omara'
			theStudents = session.createQuery("from Student s where s.lastName = 'Omara'").getResultList();
			
			// display the students: lastName='Omara'
			System.out.println("\n\nAll Students lastName=Omara...");
			displayStudents(theStudents);
			
			// query students
			theStudents = session.createQuery("from Student s where s.firstName='Mohamed'" + " OR s.email='Khaled@gmail.com'").getResultList();
			
			// display the students
			System.out.println("\n\nAll Students firstName=Mohamed OR email=Khaled@gmail.com...");
			displayStudents(theStudents);
			
			// query students
			theStudents = session.createQuery("from Student s where s.email LIKE 'Khaled%'").getResultList();
			
			// display the students
			System.out.println("\n\nAll Students email start with Khaled...");
			displayStudents(theStudents);
			
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

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent.toString());
		}
	}

}
