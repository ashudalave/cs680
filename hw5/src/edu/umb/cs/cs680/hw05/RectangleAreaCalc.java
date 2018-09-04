/**
 * 
 */
package edu.umb.cs.cs680.hw05;

import java.awt.Point;
import java.util.ArrayList;

/**
 * @author Ashuthosh
 *
 */
public class RectangleAreaCalc implements AreaCalculator {

	private Point a, b, c, d;
	private float area; 
	
	@Override
	public float getArea(ArrayList<Point> points) {
		this.a = points.get(0);
		this.b = points.get(1);
		this.c = points.get(2);
		this.d = points.get(3);
		
		float length = getPoints(a, b);
		float width = getPoints(a, c);
		
		area = length * width;
		return area;
	}
	
	public float getPoints(Point a, Point b)
	{
	  float dx = a.x - b.x; 
	  float dy = a.y - b.y;
	  return (float) Math.sqrt(dx * dx + dy * dy);
	}

}
