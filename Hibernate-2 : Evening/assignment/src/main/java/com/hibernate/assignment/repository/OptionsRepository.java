package com.hibernate.assignment.repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hibernate.assignment.Answers;
import com.hibernate.assignment.School;

@Repository
@Transactional
public class OptionsRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public void addAnswer(Answers answer) {
		entityManager.persist(answer);
	}
	
	public Answers getAnswerbyId(Integer id) {
		return entityManager.find(Answers.class,id);
	}
	
	public Answers getAnswerbyisCorrect(Boolean correct) {
		return entityManager.find(Answers.class,correct);
	}
	
	public ArrayList<Answers> getAnswersUsingQuery(Boolean correct) {
		Query query = entityManager.createQuery("SELECT a FROM Answers a WHERE a.isCorrect= :correct");
		query.setParameter("correct", correct);
		return (ArrayList<Answers>) (query.getResultList());
	}
}
