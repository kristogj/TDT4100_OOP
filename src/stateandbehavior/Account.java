package stateandbehavior;

public class Account {
	
	Double balance = 0.0;
	Double intrestRate = 0.0;
	
	
	public void deposit(Double verdi) {
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
	
	public Double getInterestRate() {
		return intrestRate;
	}
	
	public void setInterestRate(Double rate) {
		if (rate > 0 && intrestRate < 100) {
			intrestRate = rate;
		}
	}

}

