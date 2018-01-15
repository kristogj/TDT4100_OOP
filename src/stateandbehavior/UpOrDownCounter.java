package stateandbehavior;

public class UpOrDownCounter {
	
	int counter,end;
	
	public UpOrDownCounter(int start,int end){
		if (start == end) {
			throw new IllegalArgumentException();
		}
		this.counter = start;
		this.end = end;
	}
	
	public int getCounter() {
		return this.counter;
	}
	
	public boolean count() {
		if (!(counter == end)){
			if (end < counter) {
				counter -= 1;
			}
			else {
				counter += 1;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Integer.toString(counter);
	}
	
	public static void main(String[] args) {
		UpOrDownCounter counter = new UpOrDownCounter(0, -10);
		boolean bool = true;
		while (bool == true) {
			System.out.println(counter);
			bool = counter.count();
		}
	}
	

}
