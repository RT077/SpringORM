package com.Spring.ORM.dao;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.Spring.ORM.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	// inserting
	
	@Transactional
	public int insert(Student student) {

		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}

	// get all Student

	public List<Student> getAllStduents() {
		List<Student> loadAll = this.hibernateTemplate.loadAll(Student.class);
		return loadAll;

	}

	// Deleting data

	@Transactional
	public void delete(Student student) {
		this.hibernateTemplate.delete(student);

	}

	// Updataing data

	@Transactional
	public void update(Student student) {
		this.hibernateTemplate.update(student);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
