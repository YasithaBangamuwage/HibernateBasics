/**
 * 
 */
package com.yas.hibernateBasics.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yas.hibernateBasics.model.Student;

/**
 * @author YAS
 *
 */
public class CRUDMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Insert values
		Student student = new Student();
		student.setName("yasitha");
		session.save(student);

		// Read values
		// need to pass the class name of the object and the primary key of
		// Relevant object.
		Student student2 = (Student) session.get(Student.class, 1);
		System.out.println("Student name: " + student2.getName());

		// update values
		student2.setName("Yasitha Thilantha");
		session.update(student2);

		// Delete values
		// this will delete all the values related to that object.
		session.delete(student2);

		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

}
