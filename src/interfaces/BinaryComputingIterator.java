package interfaces;

import java.util.Iterator;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements Iterator<Double>{

	private Iterator<Double> iterator1, iterator2;
	private BinaryOperator<Double> function;
	private Double default1,default2;
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2,BinaryOperator<Double> function) {
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.function = function;
		
	}
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2,Double default1, Double default2,
			BinaryOperator<Double> function) {
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.default1 = default1;
		this.default2 = default2;
		this.function = function;
	}
	
	@Override
	public boolean hasNext() {
		//Only tree states for hasNext()
		return (iterator1.hasNext() && iterator2.hasNext()) || (iterator1.hasNext() && default2 != null) || (default1 != null && iterator2.hasNext());
	}

	@Override
	public Double next() {
		Double op1 = iterator1.hasNext() ? iterator1.next() : default1;
		Double op2 = iterator2.hasNext() ? iterator2.next() : default2;
		return function.apply(op1, op2);
	}
	
	

}
