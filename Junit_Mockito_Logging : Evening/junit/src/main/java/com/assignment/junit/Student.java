package com.assignment.junit;

public class Student {
	
	private String name = "Esha Jaiswal";

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String roleCourse(Subject subject) {
		return ("Subject is: "+subject.getSubject());
	}
}
