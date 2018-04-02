package inheritance;

public class SavingsAccount2 extends AbstractAccount {
	
	private int withdrawls, withdrawCounter;
	private double fee;
	
	public SavingsAccount2(int withdrawals, double fee) {
		this.withdrawls = withdrawals;
		this.fee = fee;
	}
	
	@Override
	void internalWithdraw(double amount) {
		amount = withdrawCounter >= withdrawls ? amount + fee : amount;
		if(balance < amount) {
			throw new IllegalStateException();
		}
		balance -= amount;
		withdrawCounter += 1;
	}
	
}
