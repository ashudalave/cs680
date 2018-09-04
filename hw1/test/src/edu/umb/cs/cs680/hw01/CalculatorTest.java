/**
 * 
 */
package edu.umb.cs.cs680.hw01;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

/**
 * @author Ashuthosh
 *
 */
public class CalculatorTest {
	@Test
	public void multiply3by4() {
		Calculator cut = new Calculator();
		float expected = 12;
		float actual = cut.multiply(3, 4);
		assertThat(actual,is(expected));
	}
	@Test
	public void divide3by2() {
		Calculator cut = new Calculator();
		float expected = 1.5f;
		float actual = cut.divide(3, 2);
		assertThat(actual,is(expected));
	} 
	@Test(expected=IllegalArgumentException.class)
	public void divide5by0() {
		Calculator cut = new Calculator();
		cut.divide(5, 0);
	}
	@Test
	public void multiple2_5By5_5(){
		Calculator cut = new Calculator();
		float expected = 13.75f;
		float actual = cut.multiply(2.5f, 5.5f);
		assertThat(actual,is(expected));
	}
	@Test
	public void divide2By5() {
		Calculator cut = new Calculator();
		float expected = 0.4f;
		float actual = cut.divide(2f, 5f);
		assertThat(actual,is(expected));
	}
}
