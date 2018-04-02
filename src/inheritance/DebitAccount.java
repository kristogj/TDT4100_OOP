package inheritance;

public class DebitAccount extends AbstractAccount {

	@Override
	void internalWithdraw(double amount) {
		if(balance < amount) {
			throw new IllegalStateException();
		}
		balance -= amount;
	}

}
