/**
 * 
 */
package com.yas.hibernateBasics.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author YAS 
 * used to one to one mapping.
 */

@Entity
public class StudentInfo {

	@Id
	// The name of the primary key generator to use as specified in the
	// @GenericGenerator
	@GeneratedValue(generator = "newGenerator")
	@GenericGenerator(name = "newGenerator", strategy = "foreign", parameters = {
			@Parameter(value = "student", name = "property") })
	private int studentNo;
	private int phoneNo;

	// @OneToOne StudentInfo class having one to one mapping with Student
	@OneToOne(cascade = CascadeType.ALL)
	// column name that join with student object
	@JoinColumn(name = "studentNo")
	private Student student;

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student
	 *            the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return the studentNo
	 */
	public int getStudentNo() {
		return studentNo;
	}

	/**
	 * @param studentNo
	 *            the studentNo to set
	 */
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	/**
	 * @return the phoneNo
	 */
	public int getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo
	 *            the phoneNo to set
	 */
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

}
