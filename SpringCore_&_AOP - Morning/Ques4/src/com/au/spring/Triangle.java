package com.au.spring;
import java.lang.Math;

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
	
	private Double height;
	
	private Double width;
	
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
   
	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}
	
	public void draw() {
		System.out.println("PointA : ("+getPtA().getX()+","+getPtA().getY()+")");
		System.out.println("PointB : ("+getPtB().getX()+","+getPtB().getY()+")");
		System.out.println("PointC : ("+getPtC().getX()+","+getPtC().getY()+")");
		Integer y0 = ((getPtB().getY())-(getPtA().getY())) * ((getPtB().getY())-(getPtA().getY()));
		Integer x0 = ((getPtB().getX())-(getPtA().getX())) * ((getPtB().getX())-(getPtA().getX()));
		width = Math.sqrt(x0+y0);
		
		Double area = Math.abs((((getPtA().getX())*((getPtB().getY())-(getPtC().getY()))) + ((getPtB().getX())*((getPtC().getY())-(getPtA().getY()))) + ((getPtC().getX())*((getPtA().getY())-(getPtB().getY())))) / 2.0);
		height = (area*2)/width;
		System.out.println("Width: "+width);
		System.out.println("height: "+height);
	}

	public void onInit() {
		System.out.println("Triangle bean initialized");
	}
	
	public void onCleanup() {
		System.out.println("Triangle bean destroyed");
	}

}

