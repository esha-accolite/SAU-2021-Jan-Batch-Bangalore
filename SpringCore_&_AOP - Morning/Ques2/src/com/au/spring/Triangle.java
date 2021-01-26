package com.au.spring;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


//import org.springframework.beans.factory.DisposableBean;
//InitializingBean is a marker for spring to call method of bean after initiliazation of bean
//import org.springframework.beans.factory.InitializingBean;


public class Triangle { //implements InitializingBean , DisposableBean 
	@Autowired
	@Qualifier("PointA")
	private Point PointA;
	
	@Autowired
	@Qualifier("PointB")
	private Point PointB;
	
	@Autowired
	@Qualifier("PointC")
	private Point PointC;
	
	private Set<Point> st;
	
	private List<Point> points; 
	
	private Map<Point,Point> lines;
	

	public Set<Point> getSt() {
		return st;
	}

	public void setSt(Set<Point> st) {
		this.st = st;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public Map<Point, Point> getLines() {
		return lines;
	}

	public void setLines(Map<Point, Point> lines) {
		this.lines = lines;
	}

	public Point getPointA() {
		return PointA;
	}
	
	public void setPointA(Point PointA) {
		this.PointA = PointA;
	}

	
	public Point getPointB() {
		return PointB;
	}
 
	
	public void setPointB(Point pointB) {
		this.PointB = pointB;
	}

	public Point getPointC() {
		return PointC;
	}

	public void setPointC(Point pointC) {
		this.PointC = pointC;
	}
   
	
	public void draw() {
		System.out.println("PointA"+getPointA().getX()+"PointA"+getPointA().getY());
		System.out.println("PointB"+getPointB().getX()+"PointB"+getPointB().getY());
		System.out.println("PointC"+getPointC().getX()+"PointC"+getPointC().getY());
		for(Point point:points) {
			System.out.println("PointA = "+point.getX()+","+point.getY());
		}
		
		for(Map.Entry <Point,Point> line: lines.entrySet() ) {
			System.out.println("Line EndPoints : ("+line.getKey().getX()+","+line.getKey().getY()+") and ("+line.getValue().getX()+","+line.getValue().getY()+")");
		}
		
		for(Point st:st ) {
			System.out.println("Set Values : \n"+st.getX()+","+st.getY());
		}
	}
 
	
	/*@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Triangle bean initialized");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Triangle bean destroyed");
		
	}*/
	
	

	//when we dont want to implement interfaces specific to spring, write own menthods and refer from xml
	public void onInit() {
		System.out.println("Triangle bean initialized");
	}
	
	public void onCleanup() {
		System.out.println("Triangle bean destroyed");
	}

}
