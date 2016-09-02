/**
 * 
 */
package com.yas.hibernateBasics.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yas.hibernateBasics.model.City;
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
		// many students have one City
		/*City city = new City();
		city.setCityName("colombo");

		Student student = new Student();
		student.setName("yasitha");
		student.setBirthDate(new Date());
		student.setCity(city);

		Student student2 = new Student();
		student2.setName("thilantha");
		student2.setBirthDate(new Date());
		student2.setCity(city);

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
		// one City have many students

		City city = new City();
		city.setCityName("colombo");

		Student student = new Student();
		student.setName("yasitha");
		student.setBirthDate(new Date());
		student.setCity(city);

		Student student2 = new Student();
		student2.setName("thilantha");
		student2.setBirthDate(new Date());
		student2.setCity(city);

		city.getStudents().add(student);
		city.getStudents().add(student2);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(city);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

}
