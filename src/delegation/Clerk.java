package delegation;

import java.util.function.BinaryOperator;



public class Clerk implements Employee {
	
	private Printer printer;
	private int calculations;
	
	public Clerk(Printer printer) {
		this.printer = printer;
		this.calculations = 0;
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		this.calculations++;
		return operation.apply(value1, value2);
	}

	@Override
	public void printDocument(String document) {
		this.printer.printDocument(document, this);
	}

	@Override
	public int getTaskCount() {
		return this.calculations + this.printer.getPrintHistory(this).size();
	}

	@Override
	public int getResourceCount() {
		return 1;
	}

}
