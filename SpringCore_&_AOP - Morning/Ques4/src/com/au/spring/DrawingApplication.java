package com.au.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {
		ApplicationContext config = new AnnotationConfigApplicationContext(AppConfig.class);
		Rectangle rectangle = (Rectangle)config.getBean("rect");
		rectangle.draw();
		
		ApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml");
		Triangle triangle = (Triangle)factory.getBean("triangle");
		triangle.draw();
		
		
		
		
	}

}
