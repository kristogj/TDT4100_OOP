package stateandbehavior;

public class Account {
	
	Double balance = 0.0;
	int intrestRate;
	
	
	public void deposit(int verdi) {
		if (verdi > 0.0){
			balance += verdi;
		}
	}
	
	public void addInterest() {
		balance += (balance*intrestRate)/100;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public int getInterestRate() {
		return intrestRate;
	}
	
	public void setInterestRate(int rate) {
		if (rate > 0 && intrestRate < 100) {
			intrestRate = rate;
		}
	}

}

