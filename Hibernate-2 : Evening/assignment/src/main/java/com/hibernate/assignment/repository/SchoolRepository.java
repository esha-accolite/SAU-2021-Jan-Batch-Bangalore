package com.hibernate.assignment.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hibernate.assignment.School;

@Repository
@Transactional
public class SchoolRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void addSchool(School school) {
		entityManager.persist(school);
	}
	
	public School getSchoolbyId(Integer id) {
		return entityManager.find(School.class,id);
	}
	
	public ArrayList<School> getSchoolUsingQuery(Integer id) {
		Query query = entityManager.createQuery("SELECT s FROM School s WHERE s.id= :id");
		query.setParameter("id", id);
		return (ArrayList<School>) (query.getResultList());
	}

}
