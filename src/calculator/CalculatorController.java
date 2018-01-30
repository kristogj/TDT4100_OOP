package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
	
	
	@FXML
	TextField valueTextField;
	
	Calculator cal;
	
	@FXML
	public void initialize() {
		cal = new Calculator();
		valueTextField.setText(Double.toString(cal.memory));
	}
	
	@FXML
	public void handleDigitButton(ActionEvent event) {
		Button button = (Button) event.getSource();
		cal.append(button.getText());
		updateValueTextField();
	}
	
	@FXML
	public void storeOperator(ActionEvent event) {
		Button button = (Button) event.getSource();
		String operator = button.getText();
		
		if(cal.operator != null) {
			computeAndStoreValue();
		}
		
		double val = cal.valueText == null ? cal.memory:Double.valueOf(cal.valueText);
		cal.setMemory(val);
		cal.setValueText(null);
		cal.setOperator(operator);
	}
	
	@FXML
	public void computeAndStoreValue() {
		cal.compute();
		valueTextField.setText(Double.toString(cal.getMemory()));	
	}
	
	@FXML
	public void clearAll() {
		initialize();
	}
	
	
	public void updateValueTextField() {
		valueTextField.setText(cal.getValueText());
	}
	
	public void clearValueTextField() {
		valueTextField.setText("");
	}
	
	
	

}
