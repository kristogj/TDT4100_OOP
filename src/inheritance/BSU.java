package inheritance;

public class BSU extends SavingsAccount {
	
	private double yearDeposit, depositLimit;
	
	public BSU(double intrestRate, double depositLimit) {
		super(intrestRate);
		this.depositLimit = depositLimit;
	}
	
	public double getTaxDeduction() {
		double res = 0.20 * yearDeposit;
		yearDeposit = 0;
		return res;
	}
	
	@Override
	public void deposit(double amount) {
		if(yearDeposit + amount  > depositLimit) {
			throw new IllegalStateException();
		}
		super.deposit(amount);
		yearDeposit += amount;
	}
	
	@Override
	public void withdraw(double amount) {
		if(amount > yearDeposit) {
			throw new IllegalStateException();
		}
		super.withdraw(amount);
		yearDeposit -= amount;
	}
	
	@Override
	public void endYearUpdate() {
		super.endYearUpdate();
		//Must call to reset yearDeposit
		getTaxDeduction();
	}

}
