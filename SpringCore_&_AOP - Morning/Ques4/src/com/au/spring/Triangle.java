package com.au.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Triangle { 
	@Autowired
	@Qualifier("PtA")
	private Point PtA;
	
	@Autowired
	@Qualifier("PtB")
	private Point PtB;
	
	@Autowired
	@Qualifier("PtC")
	private Point PtC;
	
//	private Integer Height;
//	
//	private Integer Width;
	
	public Point getPtA() {
		return PtA;
	}
	
	public void setPtA(Point PtA) {
		this.PtA = PtA;
	}

	
	public Point getPtB() {
		return PtB;
	}
 
	
	public void setPtB(Point ptB) {
		this.PtB = ptB;
	}

	public Point getPtC() {
		return PtC;
	}

	public void setPtC(Point ptC) {
		this.PtC = ptC;
	}
   
	
	public void draw() {
		System.out.println("PointA"+getPtA().getX()+"PointA"+getPtA().getY());
		System.out.println("PointB"+getPtB().getX()+"PointB"+getPtB().getY());
		System.out.println("PointC"+getPtC().getX()+"PointC"+getPtC().getY());
	}
 
	public void onInit() {
		System.out.println("Triangle bean initialized");
	}
	
	public void onCleanup() {
		System.out.println("Triangle bean destroyed");
	}

}
