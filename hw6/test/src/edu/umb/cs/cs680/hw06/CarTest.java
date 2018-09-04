package edu.umb.cs.cs680.hw06;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import edu.umb.cs.cs680.hw06.Car;
import edu.umb.cs.cs680.hw06.MileageComparator;
import edu.umb.cs.cs680.hw06.PriceComparator;
import edu.umb.cs.cs680.hw06.YearComparator;

/**
 * @author Ashuthosh
 *
 */
public class CarTest {

	@Test
	public void carTest() {
		ArrayList<Car> usedCars = new ArrayList<Car>();
		usedCars.add(new Car("Audi",1000, 2010, 12700)); 
		usedCars.add(new Car("BMW",1064, 2000, 19800)); 
		usedCars.add(new Car("Chevy",1732, 2017, 62000)); 
		usedCars.add(new Car("Dodge",1980, 2001, 57000));
		
		System.out.println("Unsorted Array:");
		for (Car c1:usedCars) {
			System.out.println(c1+" | "+c1.getPrice()+" |  "+c1.getYear()+" | "+c1.getMileage());
			} 
		
		Collections.sort(usedCars, new PriceComparator());
		System.out.println("\nSorting Cars by Price: ");
		for(Car car: usedCars){ 
			System.out.println(car.getPrice());
		}

		Collections.sort(usedCars, new YearComparator()); 
		System.out.println("\nSorting Cars by Year: ");
		for(Car car: usedCars){ 
			System.out.println(car.getYear());
		}
		
		Collections.sort(usedCars, new MileageComparator()); 
		System.out.println("\nSorting Cars by Mileage:");
		for(Car cars : usedCars){
			System.out.println(cars.getMileage());
		}
		
	}	

}
