package inheritance;

public class PassengerCar extends TrainCar {
	
	//The average weight of a passenger is 80 kg
	private int passengerCount;
	
	public PassengerCar(int carWeight,int passengerCount) {
		super(carWeight);
		this.passengerCount = passengerCount;
	}
	
	
	public int getPassengerCount() {
		return passengerCount;
	}
	
	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}
	
	@Override
	public int getTotalWeight() {
		return super.getDeadWeight() + (80 * getPassengerCount());
	}
	
	@Override
	public String toString() {
		return "(#PassengerCar | TotalWeight: " + getTotalWeight() + " | PassengerCount: " + getPassengerCount() + " )";
	}
	
	
	
	
	

}
