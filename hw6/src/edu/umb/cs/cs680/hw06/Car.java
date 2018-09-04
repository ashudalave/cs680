/**
 * 
 */
package edu.umb.cs.cs680.hw06;

/**
 * @author Ashuthosh
 *
 */
public class Car {
	
	private float price;
	private int year;
	private float mileage;
	private String carName;
	
	public Car(String carName, float price, int year, float mileage) {
		this.carName = carName;
		this.price = price;
		this.year = year;
		this.mileage = mileage;
	}

	public float getPrice() {
		return price;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return  carName;
	}

	public float getMileage() {
		return mileage;
	}
}
