package edu.umb.cs.cs680.hw04;

import static org.hamcrest.CoreMatchers.is;



public class Test {

	SavingsAccount sav = new SavingsAccount(111, 20000);
	CheckingAccount chk = new CheckingAccount(111, 400000, sav);

	@org.junit.Test
	public void test() {
		Account acc1 = (Account) chk;
		System.out.println("Checking Balance " + acc1.getBalance());
	
	}

	@org.junit.Test
	public void testSavingsBalance() {
		Account acc1 = (Account) sav;
		System.out.println("Savings Balance " + acc1.getBalance());
	}

}
