package com.Spring.ORM.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_details")
public class Student {
	@Id
	@Column(name = "student_id")
	private int std_id;

	@Column(name = "student_name")
	private String std_name;

	@Column(name = "student_city")
	private String std_city;

	public Student() {
		super();
	}

	public Student(int std_id, String std_name, String std_city) {
		this.std_id = std_id;
		this.std_name = std_name;
		this.std_city = std_city;
	}

	public int getStd_id() {
		return std_id;
	}

	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}

	public String getStd_name() {
		return std_name;
	}

	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}

	public String getStd_city() {
		return std_city;
	}

	public void setStd_city(String std_city) {
		this.std_city = std_city;
	}

	@Override
	public String toString() {
		return "Student [std_id=" + std_id + ", std_name=" + std_name + ", std_city=" + std_city + "]";
	}

}
