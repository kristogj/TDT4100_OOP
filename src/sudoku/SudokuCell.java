package sudoku;

public class SudokuCell {
	
	//The cells value, String because it can be preset "(value)", conflict "value*", empty "." or just "value"
	private char value;
	//Is the cell set from start?
	private boolean preset; 
	
	public SudokuCell(char value, boolean preset) {
		this.value = value;
		this.preset = preset;
	}
	
	
	public String getValue() {
		return "" + value;
	}
	
	public void setValue(char value) {
		this.value = value;
	}
	
	public boolean getPreset() {
		return this.preset;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+ this.value;
	}
}
