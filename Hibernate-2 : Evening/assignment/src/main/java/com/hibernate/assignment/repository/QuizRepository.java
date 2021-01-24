package com.hibernate.assignment.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hibernate.assignment.Quiz;

@Repository
@Transactional
public class QuizRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public void addQuiz(Quiz quiz) {
		entityManager.persist(quiz);
	}
	
	public Quiz getQuizbyId(Integer id) {
		return entityManager.find(Quiz.class,id);
	}
	
	public Quiz getQuizbyQuestion(String question) {
		return entityManager.find(Quiz.class,question);
	}
}
