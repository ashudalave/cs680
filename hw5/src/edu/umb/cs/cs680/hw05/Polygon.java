package edu.umb.cs.cs680.hw05;

import java.awt.Point;
import java.util.ArrayList;

public class Polygon {
	private ArrayList<Point> points;
	private AreaCalculator areaCalc;
	
	public Polygon(ArrayList<Point> points, AreaCalculator areaCalc) {
		this.points = points;
		this.areaCalc = areaCalc;
	}

	public void setAreaCalc(AreaCalculator areaCalc) {
		this.areaCalc = areaCalc;
	}
	
	public void addPoint(Point point) {
		this.points.add(point);
	}
	
	public float getArea() {
		return areaCalc.getArea(points);
	}
	
	/*public static void main(String[] args) {
		ArrayList<Point> al = new ArrayList<Point>();
		al.add(new Point(4,6));
		al.add(new Point(7,7));
		al.add(new Point(11,3));
		
		Polygon p = new Polygon(al, new TriangleAreaCalc());
		float area1 = p.getArea();
		p.getArea();
		System.out.println("Triangle: " + area1);
		p.addPoint(new Point(0,2));
		p.setAreaCalc(new RectangleAreaCalc());
		System.out.println("Rectangle: " + p.getArea());
	}*/
}
