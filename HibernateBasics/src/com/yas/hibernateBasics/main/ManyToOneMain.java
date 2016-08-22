/**
 * 
 */
package com.yas.hibernateBasics.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yas.hibernateBasics.model.Course;
import com.yas.hibernateBasics.model.Student;

/**
 * @author YAS
 *
 */
public class ManyToOneMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// many to one mapping
		// many students have one course
		/*Course course = new Course();
		course.setCourseName("IT");

		Student student = new Student();
		student.setName("yasitha");
		student.setBirthDate(new Date());
		student.setCourse(course);

		Student student2 = new Student();
		student2.setName("thilantha");
		student2.setBirthDate(new Date());
		student2.setCourse(course);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// we are saving only studentInfo objet.Hibernate will automatically
		// insert student object.
		session.save(student);
		session.save(student2);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();*/

		// one to many mapping
		// one course have many students

		Course course = new Course();
		course.setCourseName("IT");

		Student student = new Student();
		student.setName("yasitha");
		student.setBirthDate(new Date());
		student.setCourse(course);

		Student student2 = new Student();
		student2.setName("thilantha");
		student2.setBirthDate(new Date());
		student2.setCourse(course);

		course.getStudents().add(student);
		course.getStudents().add(student2);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(course);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

}
