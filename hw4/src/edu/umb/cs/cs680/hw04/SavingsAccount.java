package edu.umb.cs.cs680.hw04;

public class SavingsAccount extends Account {

	private float sbalance;

	public SavingsAccount(int id, float balance) {
		super(id,balance);
		this.sbalance = balance;
	}

	
	public float withdraw(float amount) throws InsufficientFundsException {
		if (this.getBalance() > amount) {
			this.sbalance = this.sbalance - amount;
		} else if (this.getBalance() < 0) {
			throw new InsufficientFundsException();
		}
		System.out.println("Amount withdrawn from savings account" +amount);
		return this.sbalance;
	}

}
