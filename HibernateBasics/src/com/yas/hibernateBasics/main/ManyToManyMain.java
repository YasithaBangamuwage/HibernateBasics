/**
 * 
 */
package com.yas.hibernateBasics.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yas.hibernateBasics.model.City;
import com.yas.hibernateBasics.model.Course;
import com.yas.hibernateBasics.model.Student;

/**
 * @author YAS
 *
 */
public class ManyToManyMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		City city = new City();
		city.setCityName("colombo");

		Course course1 = new Course();
		course1.setCourseName("IT");

		Course course2 = new Course();
		course2.setCourseName("Managment");

		Student student = new Student();
		student.setName("yasitha");
		student.setBirthDate(new Date());
		student.setCity(city);
		student.getCourses().add(course1);

		Student student2 = new Student();
		student2.setName("thilantha");
		student2.setBirthDate(new Date());
		student2.setCity(city);
		student2.getCourses().add(course1);
		student2.getCourses().add(course2);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// we are saving only studentInfo objet.Hibernate will automatically
		// insert student object.
		session.save(student);
		session.save(student2);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

}
