package edu.umb.cs.cs680.hw04;

public class CheckingAccount extends Account {
	
	private float cbalance;
	private SavingsAccount savAcc;
	
	public CheckingAccount(int id,float balance, SavingsAccount savAcc) {
		super(id,balance);
		this.cbalance=balance;
		this.savAcc=savAcc;
	}
	
	public float withdraw(float amount) throws InsufficientFundsException {
		
		if(this.getBalance() > amount) {
			this.cbalance=this.cbalance-amount;
		}else if(savAcc.getBalance() + this.getBalance()>=amount) {
			this.cbalance=(this.cbalance-amount) -500; 
					
		}else if(savAcc.getBalance()+ this.getBalance()<0) {
			throw new InsufficientFundsException();
		}else if(this.getBalance()<0) {
			throw new InsufficientFundsException();
		}
		System.out.println("Amount withdrawn from checking account" +amount);
		return cbalance;
		
	}
	
}
