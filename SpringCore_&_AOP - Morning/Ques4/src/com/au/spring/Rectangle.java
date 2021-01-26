package com.au.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Rectangle {
	
	@Autowired
	@Qualifier("PointA")
	private Point PointA;
	
	@Autowired
	@Qualifier("PointB")
	private Point PointB;
	
	@Autowired
	@Qualifier("PointC")
	private Point PointC;
	
	@Autowired
	@Qualifier("PointD")
	private Point PointD;

	public Point getPointA() {
		return PointA;
	}

	public void setPointA(Point pointA) {
		PointA = pointA;
	}

	public Point getPointB() {
		return PointB;
	}

	public void setPointB(Point pointB) {
		PointB = pointB;
	}

	public Point getPointC() {
		return PointC;
	}

	public void setPointC(Point pointC) {
		PointC = pointC;
	}

	public Point getPointD() {
		return PointD;
	}

	public void setPointD(Point pointD) {
		PointD = pointD;
	}
	
	public void draw() {
		System.out.println("PointA : ("+getPointA().getX()+","+getPointA().getY()+")");
		System.out.println("PointB : ("+getPointB().getX()+","+getPointB().getY()+")");
		System.out.println("PointC : ("+getPointC().getX()+","+getPointC().getY()+")");
		System.out.println("PointD : ("+getPointD().getX()+","+getPointD().getY()+")");
	}

}

