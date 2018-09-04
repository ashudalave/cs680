/**
 * 
 */
package edu.umb.cs.cs680.hw06;

import java.util.Comparator;

/**
 * @author Ashuthosh
 *
 */
public class MileageComparator implements Comparator<Car> {
	
	public int compare(Car car1, Car car2) {
		return (int) (car1.getMileage()-car2.getMileage());
	}

}
