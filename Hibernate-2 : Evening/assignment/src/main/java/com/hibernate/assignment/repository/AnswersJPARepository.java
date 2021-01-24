package com.hibernate.assignment.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.hibernate.assignment.Answers;

public interface AnswersJPARepository extends CrudRepository<Answers,Integer>{

	public Answers findAnswersById(Integer id);
	
	public ArrayList<Answers> findAnswersOrderByQuestion();
}
