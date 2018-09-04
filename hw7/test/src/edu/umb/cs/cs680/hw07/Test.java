package edu.umb.cs.cs680.hw07;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class Test {

	@org.junit.Test
	public void test1() {
		String actual;
		String expected;
		FileCache file = new FileCache();
		file.changePolicy(new FIFO());
		actual = "";
		expected = "";
		assertThat(actual, is(expected));
		
	}
	
	@org.junit.Test
	public void test2() {
		String actual;
		String expected;
		FileCache file = new FileCache();
		file.changePolicy(new FIFO());
		actual = "abc.txt";
		expected = "abc.txt";
		assertThat(actual, is(expected));
		
	}

}
