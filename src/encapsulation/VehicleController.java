package encapsulation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class VehicleController {
	
	@FXML
	Label typeLabel,fuelLabel,regLabel;
	
	@FXML
	TextField typeField,fuelField,regField;
	
	@FXML
	TextArea messageArea;
	
	@FXML
	Button updateButton;
	
	
	
	
	public void update(){
		char type = typeField.getText().toUpperCase().charAt(0);
		char fuel = fuelField.getText().toUpperCase().charAt(0);
		String regNr = regField.getText().toUpperCase();
		try {
			Vehicle v = new Vehicle(type,fuel,regNr);
			typeLabel.setText(Character.toString(v.getVehicleType()));
			fuelLabel.setText(Character.toString(v.getFuelType()));
			regLabel.setText(v.getRegistrationNumber());
		} catch (Exception e) {
			messageArea.setText(e.getMessage());
		}
	}
	
	
	
	
}
