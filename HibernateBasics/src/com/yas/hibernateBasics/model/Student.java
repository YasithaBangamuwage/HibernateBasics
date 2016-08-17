/**
 * 
 */
package com.yas.hibernateBasics.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author YAS 
 * This class contain basic hibernate annotations.
 */

// @Entity mention the entity
@Entity
// @Table mention the table name if we wants to set name other than model name
@Table(name = "Student")
public class Student {

	// @Id for mention the primary key
	// @GeneratedValue for auto generated primary key value
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentNo;

	// Change the column name other than variable name in model class, set not
	// nullable to column value
	@Column(name = "studentName", nullable = false)
	// Completely ignore the column
	//@Transient
	private String name;

	// Store only date in the column value
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	//used for bidirectional one to one mapping
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "studentNo")
	private StudentInfo studentInfo;
	

	/**
	 * @return the studentInfo
	 */
	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	/**
	 * @param studentInfo the studentInfo to set
	 */
	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
