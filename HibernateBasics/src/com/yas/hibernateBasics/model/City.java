/**
 * 
 */
package com.yas.hibernateBasics.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author YAS
 *
 */
@Entity
@Table(name = "City")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cityId;
	private String cityName;

	// one City have many students
	// mappedBy value is reference to student object reference attribute

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
	private Set<Student> students = new HashSet<Student>(0);

	/**
	 * @return the students
	 */

	public Set<Student> getStudents() {
		return students;
	}

	/**
	 * @param students
	 *            the students to set
	 */
	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	/**
	 * @return the cityId
	 */
	public int getCityId() {
		return cityId;
	}

	/**
	 * @param cityId
	 *            the cityId to set
	 */
	public void setCityId(int courseId) {
		this.cityId = courseId;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName
	 *            the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
