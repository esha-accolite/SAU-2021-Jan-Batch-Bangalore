package com.hibernate.assignment.repository;

import org.springframework.data.repository.CrudRepository;

import com.hibernate.assignment.School;

public interface SchoolJPARepository extends CrudRepository<School,Integer>{
	
	public School findSchoolById(Integer id);

}
