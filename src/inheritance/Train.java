package inheritance;


import java.util.HashSet;
import java.util.Set;

public class Train {
	
	
	private Set<TrainCar> cars;
	
	public Train() {
		cars = new HashSet<TrainCar>();
	}
	
	public void addTrainCar(TrainCar trainCar) {
		cars.add(trainCar);
	}
	
	public boolean contains(TrainCar trainCar) {
		return cars.contains(trainCar);
	}
	
	public int getTotalWeight() {
		return cars.stream().mapToInt(t -> t.getTotalWeight()).sum();
	}
	
	public int getPassengerCount() {
		return cars.stream().filter(t -> t instanceof PassengerCar).mapToInt(t -> ((PassengerCar) t).getPassengerCount()).sum();
	}
	
	public int getCargoWeight() {
		return cars.stream().filter(t -> t instanceof CargoCar).mapToInt(t -> ((CargoCar) t).getCargoWeight()).sum();
	}
	
	
	public String toString() {
		return cars.toString();
	}
	
	public static void main(String[] args) {
		TrainCar cargo = new CargoCar(10,15);
		TrainCar pass = new PassengerCar(10,1);
		
		Train train = new Train();
		
		train.addTrainCar(cargo);
		train.addTrainCar(pass);
		
		System.out.println(train);
		
	}
	
	

}
