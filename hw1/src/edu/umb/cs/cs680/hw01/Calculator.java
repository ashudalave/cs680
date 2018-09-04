package edu.umb.cs.cs680.hw01;

public class Calculator {
	public float multiply(float x, float y){
		return x*y;
	}
	
	public float divide(float x, float y) {
		if(y==0) {
			throw new IllegalArgumentException("division by zero");
		}
		return x/y;
	}
	
	public static void main(String args[]) {
		Calculator c1 = new Calculator();
		c1.multiply(2f, 3f);
		c1.divide(4f, 2f);
	}

}
