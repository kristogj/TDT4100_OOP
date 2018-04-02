package inheritance;

public class SavingsAccount implements Account {
	
	private double balance, intrestRate;
	
	public SavingsAccount(double intrestRate) {
		balance = 0;
		//0.05 is the same as 5% intrest rate
		this.intrestRate = intrestRate;
	}
	
	@Override
	public void deposit(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException();
		}
		balance += amount;

	}

	@Override
	public void withdraw(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException();
		}
		if(balance < amount) {
			throw new IllegalStateException();
		}
		balance -= amount;
	}

	@Override
	public double getBalance() {
		return balance;
	}
	
	public void endYearUpdate() {
		balance += balance * intrestRate;
	}

}
