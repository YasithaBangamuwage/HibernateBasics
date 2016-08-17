/**
 * 
 */
package com.yas.hibernateBasics.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yas.hibernateBasics.model.Student;
import com.yas.hibernateBasics.model.StudentInfo;

/**
 * @author YAS
 *
 */
public class OnetoOneMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//one to one mapping unidirectional
		Student student = new Student();
		student.setName("yasitha");
		student.setBirthDate(new Date());

		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setPhoneNo(007);  
		studentInfo.setStudent(student);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// we are saving only studentInfo objet.Hibernate will automatically
		// insert student object.
		session.save(studentInfo);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		
		//one to one mapping bidirectional
		/*Student student = new Student();
		student.setName("yasitha");
		student.setBirthDate(new Date());

		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setPhoneNo(007);  
		studentInfo.setStudent(student);

		student.setStudentInfo(studentInfo);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(student);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();*/

	}

}
