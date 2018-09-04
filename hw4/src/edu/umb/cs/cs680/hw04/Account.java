package edu.umb.cs.cs680.hw04;

public abstract class Account {
	protected float balance;
	protected int accID;
	
	public Account() {
		balance=0.0F;
		accID=000;
	}

	public Account(int id, float bal) {
		accID = id;
		balance = bal;
	}

	public float getBalance() {
		return balance;
	}

	public float deposit(float bal) {
		this.balance = bal + balance;
		System.out.println("Amount deposited is " + bal);
		return this.balance;

	}

	public abstract float withdraw(float bal) throws InsufficientFundsException;/* throws InsufficientFundsException {
		return this.balance;
	}*/

}
