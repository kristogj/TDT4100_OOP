package delegation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
	
	
	
	private List<Employee> employees;
	private int tasks;
	public Manager(Collection<Employee> employees) {
		if(employees.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.employees = new ArrayList<Employee>(employees);
		this.tasks = 0;
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		this.tasks++;
		return getRandomEmployee().doCalculations(operation, value1, value2);
	}

	@Override
	public void printDocument(String document) {
		this.tasks++;
		getRandomEmployee().printDocument(document);
	}

	@Override
	public int getTaskCount() {
		return this.tasks;
	}

	@Override
	public int getResourceCount() {
		return this.employees.stream().mapToInt(e -> e.getResourceCount()).sum() + 1;
	}
	
	private Employee getRandomEmployee() {
		int index = (int) Math.random()*getResourceCount();
		return this.employees.get(index);
	}
	
	

}
