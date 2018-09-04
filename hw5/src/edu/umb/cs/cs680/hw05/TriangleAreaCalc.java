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
public class TriangleAreaCalc implements AreaCalculator {

	/* (non-Javadoc)
	 * @see edu.umb.cs.cs680.hw05.AreaCalculator#getArea(java.util.ArrayList)
	 */
	private Point a ,b ,c; 
	@Override
	public float getArea(ArrayList<Point> points) {
		this.a = points.get(0);
		this.b = points.get(1);
		this.c = points.get(2);
		
		float ab = getPoints(a, b);
		float bc = getPoints(b, c);
		float ca = getPoints(c, a);
		float s = (ab + bc + ca)/2;
		
		return (float) Math.sqrt(s * (s - ab) * (s - bc) * (s - ca));
	}
	
	private float getPoints(Point a, Point b)
	{
	  float dx = a.x - b.x; 
	  float dy = a.y - b.y;
	  return (float) Math.sqrt(dx * dx + dy * dy);
	}
}	
