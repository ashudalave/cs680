package edu.umb.cs.cs680.hw05;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

public class PolygonTest {

	@Test
	public void rectangleTest() {
		ArrayList<Point> al = new ArrayList<Point>();
		al.add(new Point(4,6));
		al.add(new Point(7,7));
		al.add(new Point(11,3));
		
		Polygon p = new Polygon(al, new TriangleAreaCalc());
		p.addPoint(new Point(0,2));
		p.setAreaCalc(new RectangleAreaCalc());
		float areaTest = p.getArea();
		float actual = areaTest;
		float expected = 24.083189f;
		
		assertThat(actual, is(expected));
	}
	
	@Test
	public void triangleTest() {

		ArrayList<Point> al = new ArrayList<Point>();
		al.add(new Point(4,6));
		al.add(new Point(7,7));
		al.add(new Point(11,3));
		
		Polygon p = new Polygon(al, new TriangleAreaCalc()); 
		float areaTest = p.getArea();

		float actual = areaTest;
		float expected = 8.000004f;

		assertThat(actual, is(expected));
	}
	
		@Test
		public void dynamicTransformTest() {

			ArrayList<Point> al = new ArrayList<Point>();
			al.add(new Point(0,0));
			al.add(new Point(0,10)); 
			al.add(new Point(10,10)); 
			al.add(new Point(10,0)); 
			Polygon p = new Polygon(al, new RectangleAreaCalc()); 
			float areaTest = p.getArea();
			
			float actual = areaTest;
			float expected = 141.42136f;

			assertThat(actual, is(expected));
		}

	


}
