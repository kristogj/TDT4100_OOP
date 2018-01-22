package encapsulation;


	
public class Vehicle {
	
	private char vehicle,fuel;
	private String regnr;
	
	public Vehicle(char vehicle, char fuel, String regnr) {
		isValidType(vehicle);
		this.vehicle = vehicle;
		
		isValidFuel(fuel);
		this.fuel = fuel;
		
		setRegistrationNumber(regnr);
	}
	
	public void isValidType(char type) {
		String types = "MC";
		if (types.indexOf(type) == -1) {
			throw new IllegalArgumentException("Unvalid vehicle");
		}
	}
	
	public void isValidFuel(char fuel) {
		String valid = "HEDG";
		switch (getVehicleType()) {
		case 'C':	if (valid.indexOf(fuel) == -1) {
			throw new IllegalArgumentException("Unvalid fuel for car");
		}break;
		
		case 'M':	if(valid.substring(1).indexOf(fuel) == -1) {
			throw new IllegalArgumentException("Unvalid fuel for motorcycle");
		}break;
		}
	}
	
	public void isValidRegistrationNumber(String regnr) {
		String letter = regnr.substring(0,2);
		String number = regnr.substring(2);
		//Rules for everyone
		if( !letter.matches("[a-zA-Z]+") || !number.matches("[1-9]+") || !letter.toUpperCase().equals(letter)) {
			throw new IllegalArgumentException("Unvalid regnr, must be 2 letter and all uppercase");
		}
		//Check rules for vechiletypes
		if( (getVehicleType() == 'M' && number.length()!=4) || (getVehicleType() == 'C' && number.length()!=5)) {
			throw new IllegalArgumentException("Wrong amount of numbers in regnr");
		}
		//Check rules for fueltype
		switch (getFuelType()) {
		case 'E': if(! (regnr.startsWith("EL") || regnr.startsWith("EK" ))) {
			throw new IllegalArgumentException("Electrical vehicles must start with EK or EL");
		} break;

		case 'H': if(!regnr.startsWith("HY")) {
			throw new IllegalArgumentException("Cars on hydrgen must start with HY");
		} break;
		
		default: 
			if( regnr.startsWith("HY") || regnr.startsWith("EL") || regnr.startsWith("EK")) {
				throw new IllegalArgumentException("Cars on G or D cant start on HY,EL or EK");
			}
			break;
		}
	}
	
	public char getFuelType() {
		return this.fuel;
	}
	
	public String getRegistrationNumber() {
		return this.regnr;
	}
	
	public void setRegistrationNumber(String regnr) {
		isValidRegistrationNumber(regnr);
		this.regnr = regnr;
		
	}
	
	public char getVehicleType() {
		return this.vehicle;
	}
	
	public static void main(String[] args) {
		Vehicle v = new Vehicle('M','G',"RN1234");
		System.out.println("OK");
		
		
		
		
	}
}
