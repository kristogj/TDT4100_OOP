package inheritance;

public class CreditAccount extends AbstractAccount {
	
	private double creditLine;
	
	public CreditAccount(double creditLine) {
		this.creditLine = creditLine;
	}
	
	public void setCreditLine(double creditLine) {
		if(creditLine < 0) {
			throw new IllegalArgumentException();
		}
		if(balance < -creditLine) {
			throw new IllegalStateException();
		}
		this.creditLine = creditLine;
	}
	
	public double getCreditLine() {
		return creditLine;
	}
	
	@Override
	void internalWithdraw(double amount) {
		if(balance - amount < -creditLine) {
			throw new IllegalStateException();
		}
		balance -= amount;
	}

}
