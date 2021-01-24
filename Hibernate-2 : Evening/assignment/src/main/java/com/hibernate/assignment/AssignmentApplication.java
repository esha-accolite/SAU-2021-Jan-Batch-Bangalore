package com.hibernate.assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hibernate.assignment.repository.AddressJPARepository;
import com.hibernate.assignment.repository.AddressRepository;
import com.hibernate.assignment.repository.AnswersJPARepository;
import com.hibernate.assignment.repository.OptionsRepository;
import com.hibernate.assignment.repository.QuizRepository;
import com.hibernate.assignment.repository.SchoolJPARepository;
import com.hibernate.assignment.repository.SchoolRepository;

@SpringBootApplication
public class AssignmentApplication implements CommandLineRunner{
	
	@Autowired
	SchoolRepository schoolRepository;
	
	@Autowired
	QuizRepository quizRepository;
	
	@Autowired
	OptionsRepository optionsRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Resource
	SchoolJPARepository schoolJPARepository;
	
	@Resource
	AddressJPARepository addressJPARepository;
	
	@Resource
	AnswersJPARepository answersJPARepository;

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
//		Address address = new Address();
//		address.setAreaNo("253/100");
//		address.setLocation("some area");
//		address.setCity("delhi");
//		address.setState("delhi");
//		address.setPincode(2256434);
//		
//		Answers options = new Answers();
//		options.setOption("Option1-1");
//		options.setIsCorrect(false);
//		
//		Answers options1 = new Answers();
//		options1.setOption("Option1-2");
//		options1.setIsCorrect(false);
//		
//		Answers options2 = new Answers();
//		options2.setOption("Option1-3");
//		options2.setIsCorrect(true);
//		
//		Answers options3 = new Answers();
//		options3.setOption("Option1-4");
//		options3.setIsCorrect(false);
//		
//		Set<Answers> optionsSet = new HashSet<>();
//		optionsSet.add(options);
//		optionsSet.add(options1);
//		optionsSet.add(options2);
//		optionsSet.add(options3);
//		
//		Quiz quiz = new Quiz();
//		quiz.setQuestion("Question-2");
//		quiz.setAnswers(optionsSet);
//		
//		Set<Quiz> quizSet = new HashSet<>();
//		quizSet.add(quiz);
//		
//		School school = new School();
//		school.setAddress(address);
//		school.setQuizes(quizSet);
		
//		SchoolRepository schoolRepository = new SchoolRepository();
//		schoolRepository.addSchool(school);
		
//		schoolJPARepository.save(school);
		
//		school = schoolJPARepository.findSchoolById(1);
//		System.out.println(school.getId());
		
//		ArrayList<School> schoolList = new ArrayList();
//		schoolList = schoolJPARepository.findSchoolByIdOrderById();
//		System.out.println(schoolList.get(0).getId());
		
		
//		school = schoolRepository.getSchoolbyId(1);
//		System.out.println(school.getId());
//		System.out.println(school.getAddress());
//		System.out.println(school.getQuizes());
//		
//		
//		quiz = quizRepository.getQuizbyId(1);
//		System.out.println(quiz.getId());
//		System.out.println(quiz.getQuestion());
//		System.out.println(quiz.getAnswers());
//		
//		quiz = quizRepository.getQuizbyQuestion("Question-2");
//		System.out.println(quiz.getId());
//		System.out.println(quiz.getQuestion());
//		System.out.println(quiz.getAnswers());
		
//		ArrayList<School> schoolList = new ArrayList();
		
//		schoolList = (ArrayList<School>) schoolRepository.getSchoolUsingQuery(1);
//		System.out.println(schoolList.get(0).getId());
//		System.out.println(schoolList.get(0).getQuizes());
//		System.out.println(schoolList.get(0).getAddress());
		
//		ArrayList<Answers> answersList = new ArrayList();
		
//		answersList = (ArrayList<Answers>) optionsRepository.getAnswersUsingQuery(true);
//		System.out.println(answersList.get(0).getId());
//		System.out.println(answersList.get(1).getId());
	}

}
