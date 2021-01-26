package com.au.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(name = "PointA")
	public Point PointA() {
		return (new Point(0,0));
	}
	
	@Bean(name = "PointB")
	public Point PointB() {
		return (new Point(0,1));
	}
	
	@Bean(name = "PointC")
	public Point PointC() {
		return (new Point(1,1));
	}
	
	@Bean(name = "PointD")
	public Point PointD() {
		return (new Point(1,0));
	}
	
	@Bean(name = "rect")
	public Rectangle rectangle() {
		return (new Rectangle());
	}
}
