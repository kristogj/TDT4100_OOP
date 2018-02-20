package calculator;

public class Calculator {
	
	String valueText,operator;
	double memory = 0.0;
	
	double test = 0.0;
	
	double merge = 0.0;
	
	public Calculator() {
		
	}
	
	public void append(String digit) {
		this.valueText = this.valueText == null ? digit:this.valueText+digit;
	}
	
	public void compute() {
		double num = Double.valueOf(this.valueText);
		this.valueText = null;
		switch (operator) {
		case "+":this.memory += num;break;
		case "/":this.memory /= num;break;
		case "x":this.memory *= num;break;
		case "-":this.memory -= num;break;
		default: break;
		}
		this.operator = null;
	}
	
	
	public String getValueText() {
		return valueText;
	}
	
	public double getMemory() {
		return memory;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public void setMemory(double memory) {
		this.memory = memory;
	}
	
	public void setValueText(String valueText) {
		this.valueText = valueText;
	}
	
	
}
