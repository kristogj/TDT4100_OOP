package stateandbehavior;

public class Digit {
	
	int tallsystem, sifferverdi;
	String alfa = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public Digit(int system) {
		this.tallsystem = system;
		this.sifferverdi = 0;
	}
	
	public int getValue() {
		return sifferverdi;
	}
	
	public boolean increment() {
		this.sifferverdi += 1;
		if (this.sifferverdi == tallsystem) {
			this.sifferverdi = 0;
			return true;
		}
		return false;
	}
	
	public int getBase() {
		return tallsystem;
	}
	
	@Override
	public String toString() {
		return Character.toString(alfa.charAt(sifferverdi));
	}

	public static void main(String[] args) {
		Digit first = new Digit(10);
		Digit sec = new Digit(10);
		Digit third = new Digit(10);		
		for (int x=0; x<2000; x++) {
			System.out.println(third + "" + sec + "" + first);
			boolean tens = first.increment();
			if (tens){
				boolean hundred = sec.increment();
				if (hundred) {
					boolean tusen = third.increment();
					if(tusen) {
						first.sifferverdi = 0;
						sec.sifferverdi = 0;
						third.sifferverdi = 0;
					}
				}
			}
		}
	}
}
