package interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;



public class RPNCalc {
		
	private List<Double> stack;
	private Map<Character,BinaryOperator<Double>> binaryOperators;
	private Map<Character,UnaryOperator<Double>> unaryOperators;
	private Map<Character,Supplier<Double>> suppliers;
	
	Map<Character,HashMap> bigMap;
	
	
	public RPNCalc() {
		stack = new ArrayList<Double>();
		binaryOperators = new HashMap<Character,BinaryOperator<Double>>();
		unaryOperators = new HashMap<Character,UnaryOperator<Double>>();
		suppliers = new HashMap<Character,Supplier<Double>>();
	}
	
	public void push(double n) {
		this.stack.add(n);
	}
	
	public double pop() {
		if(stack.size() == 0) {
			return Double.NaN;
		}
		return this.stack.remove(stack.size() - 1);
	}
	
	public double peek(int index) {
		if(this.stack.size() <= index || index < 0) {
			return Double.NaN;
		}
		return this.stack.get(stack.size() - 1 - index);
	}
	
	public int getSize() {
		return this.stack.size();
	}
	
	public void performOperation(char c) {
		if (!binaryOperators.containsKey(c)) {
			throw new UnsupportedOperationException();
		}
		Double op1 = pop();
		Double op2 = pop();
		push(binaryOperators.get(c).apply(op1, op2));
	}
	
	public boolean addOperator(char c , BinaryOperator<Double> function) {
		boolean bool = checkOperatorExists(c) == null;
		if(bool) {
			binaryOperators.put(c, function);
		}
		return bool;
	}
	
	public boolean addOperator(char c , UnaryOperator<Double> function) {
		boolean bool = checkOperatorExists(c) == null;
		if(bool) {
			unaryOperators.put(c, function);
		}
		return bool;
	}
	
	public boolean addOperator(char c , Supplier<Double> function) {
		boolean bool = checkOperatorExists(c) == null;
		if(bool) {
			suppliers.put(c, function);
		}
		return bool;
	}
	
	private Map checkOperatorExists(char c) {
		if(binaryOperators.containsKey(c)) {
			return binaryOperators;
		}
		else if(unaryOperators.containsKey(c)) {
			return unaryOperators;
		}
		else if(suppliers.containsKey(c)) {
			return suppliers;
		}
		return null;
	}
	
	public void removeOperator(char c) {
		Map map = checkOperatorExists(c);
		if(map != null) {
			map.remove(c);
		}
	}
	
	
}
