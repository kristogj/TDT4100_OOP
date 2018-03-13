package sudoku;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SudokuAction {
	
	private TextField field;
	private String value;
	
	public SudokuAction(TextField field,String value) {
		this.field = field;
		this.value = value;
	}
	
	public TextField getField() {
		return field;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
