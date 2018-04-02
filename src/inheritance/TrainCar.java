package inheritance;

public class TrainCar {
	
	private int carWeight;
	
	public TrainCar(int carWeight) {
		this.carWeight = carWeight;
	}
	
	public int getTotalWeight() {
		return carWeight;
	}
	
	public void setDeadWeight(int carWeight) {
		this.carWeight = carWeight;
	}
	
	public int getDeadWeight() {
		return carWeight;
	}
	
	@Override
	public String toString() {
		return "(#TrainCar | TotalWeight: " + getTotalWeight() + ")";
	}

}
