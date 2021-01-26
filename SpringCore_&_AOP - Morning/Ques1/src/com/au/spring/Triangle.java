package com.au.spring;


import java.util.List;
import java.util.Map;
import java.util.Set;

public class Triangle {
	
	private List<Point> points; 
	
	private Map<Point,Point> lines;
	
	private Set<Point> st;
	
	public Map<Point, Point> getLines() {
		return lines;
	}

	public void setLines(Map<Point, Point> lines) {
		this.lines = lines;
	}

	public Set<Point> getSt() {
		return st;
	}

	public void setSt(Set<Point> st) {
		this.st = st;
	}

	public List<Point> getPoints(){
		return points;
	}
	
	public void setPoints(List<Point> points){
		this.points = points;
	}

	
	public void draw() {
		
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

}