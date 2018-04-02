package inheritance;

public class CargoCar extends TrainCar {
	
	private int cargoWeight;
	
	public CargoCar(int carWeight,int cargoWeight) {
		super(carWeight);
		this.cargoWeight = cargoWeight;
	}
	
	public int getCargoWeight() {
		return cargoWeight;
	}
	
	public void setCargoWeight(int cargoWeight) {
		this.cargoWeight = cargoWeight;
	}
	
	@Override
	public int getTotalWeight() {
		return super.getDeadWeight() + getCargoWeight();
	}
	
	@Override
	public String toString() {
		return "(#CargoCar | TotalWeight: " + getTotalWeight() + " | CargoWeightCount: " + getCargoWeight() + " )";
	}

}
