package stateandbehavior;

public class Account {
	
	double balance = 0.0;
	double intrestRate;
	
	
	public void deposit(double verdi) {
		if (verdi > 0.0){
			balance += verdi;
		}
	}
	
	public void addInterest() {
		balance += (balance*intrestRate)/100;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return intrestRate;
	}
	
	public void setInterestRate(double rate) {
		if (rate > 0 && intrestRate < 100) {
			intrestRate = rate;
		}
	}

}
