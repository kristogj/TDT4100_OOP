package encapsulation;



public class Account {
	
	private double balance, intrestRate;
	
	public Account(double balance, double intrestRate) {
		if(balance < 0) {
			throw new IllegalArgumentException("Invalid balance");
		}
		this.balance = balance;
		
		if(intrestRate < 0) {
			throw new IllegalArgumentException("Invalid intrestrate");
		}
		this.intrestRate = intrestRate;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getIntrestRate() {
		return this.intrestRate;
	}
	
	public void setIntrestRate(double intrestRate) {
		if(intrestRate < 0) {
			throw new IllegalArgumentException("Invalid intrestrate");
		}
		this.intrestRate = intrestRate;
	}
	
	public void deposit(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("Invalid deposit amount");
		}
		this.balance += amount;
	}
	
	public void withdraw(double amount) {
		if (amount < 0 || balance-amount < 0) {
			throw new IllegalArgumentException("Invalid withdraw amount");
		}
		this.balance -= amount;
		
	}
	
	public void addIntrest() {
		this.balance += (this.balance*this.intrestRate)/100;
	}
	
}
