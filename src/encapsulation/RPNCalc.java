package encapsulation;

import java.util.ArrayList;
import java.util.List;



public class RPNCalc {
		
	private List<Double> stack;
	
	public RPNCalc() {
		stack = new ArrayList<Double>();
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
		switch (c) {
		case '+': push(pop()+pop());break;
		case '-': double op1 = pop();double op2 = pop();push(op2-op1);break;
		case '*': push(pop()*pop());break;
		case '/': double op11 = pop(); double op22 = pop();push(op22/op11);break;
		case '~': double op111 = pop(); double op222 = pop(); push(op111); push(op222); break;
		case 'p': push(Math.PI);break;
		case 'π': push(Math.PI);break;
		case '|': push(Math.abs(pop()));break;
		default: break;
		}
	}
	
	
}
