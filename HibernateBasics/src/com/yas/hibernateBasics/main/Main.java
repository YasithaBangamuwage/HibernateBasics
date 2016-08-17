/**
 * 
 */
package com.yas.hibernateBasics.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yas.hibernateBasics.model.Student;

/**
 * @author YAS
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Student student = new Student();
		student.setName("yasitha");
		student.setStudentNo(001);
		student.setBirthDate(new Date());
		
		SessionFactory sessionFactory =new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(student);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
	}

}
