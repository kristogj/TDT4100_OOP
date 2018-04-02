package inheritance;

public class ForeldreSpar extends SavingsAccount {

	private final int legalWithdraws;
	private int remainingWithdrawals;
	
	public ForeldreSpar(double intrestRate, int legalWithdraws) {
		super(intrestRate);
		this.legalWithdraws = legalWithdraws;
		this.remainingWithdrawals = legalWithdraws;
	}
	
	public int getRemainingWithdrawals() {
		return remainingWithdrawals;
	}
	
	@Override
	public void withdraw(double amount) {
		if(remainingWithdrawals == 0) {
			throw new IllegalStateException();
		}
		super.withdraw(amount);
		remainingWithdrawals -= 1;
	}
	
	@Override
	public void endYearUpdate() {
		super.endYearUpdate();
		remainingWithdrawals = legalWithdraws;
	}

}
