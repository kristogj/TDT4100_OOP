package sudoku;

import java.util.ArrayList;
import java.util.List;

//TODO change preset cells to "value", preset is true so would be ok when using SudokuController for fxml

public class Sudoku {
	
	//The board should be representet as a string, 9x9 = 81 chars
	private String board;
	//To keep track of the SudokuCells I use an ArrayList
	private List<SudokuCell> cells;
	
	
	public Sudoku(String board) {
		this.board = board;
		setup();
	}
	
	//The setup should use the board string and make all the cells for the game
	private void setup() {
		this.cells = new ArrayList<SudokuCell>();
		for(int i = 0; i < this.board.length(); i++) {
			char value = this.board.charAt(i);
			if (value != '.') {
				this.cells.add(new SudokuCell("(" + value + ")" , true));
			}
			else {
				this.cells.add(new SudokuCell("" + value , false));
			}
		}
	}
	
	//The board would be indexed from row 1-9 and col 1-9
	public SudokuCell getCell(int x, int y) {
		return this.cells.get(x*9 + y - 10);
	}
	public boolean setCell(int x, int y,String value) {
		SudokuCell cell = getCell(x,y);
		if (!cell.getPreset() && value.length() == 1 && value.matches("[1-9]")) {
			//TODO check for value conflict
			cell.setValue(value);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String str = "+--------------+---------------+---------------+\n";
		String separate = "\n+--------------+---------------+---------------+";
		for (int x = 1; x <= 9; x++) {
			for (int y = 1; y <= 9; y++) {
				String cellString = "";
				String cellValue = this.getCell(x, y).getValue();
				switch (cellValue.length()) {
				//Correct value insert or empty cell "."
				case 1: cellString = "  " + cellValue + "  ";break;
				//Value conflict
				case 2: cellString = "  " + cellValue + " ";break;
				//Preset value
				case 3: cellString = " " + cellValue + " " ;break;
				default: break;
				}
				str += cellString;
				if (y%3 == 0) { str += "|";}
			}
			if (x%3 == 0) { str += separate;}
			str += "\n";
		}
		return str;
	}
	
	public static void main(String[] args) {
		Sudoku s = new Sudoku(".....2..38.273.45....6..87.9.8..5367..6...1..4513..9.8.84..3....79.512.62..8.....");
		System.out.println(s);
	}

}
