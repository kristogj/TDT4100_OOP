package sudoku;

import java.util.ArrayList;
import java.util.List;

//TODO change preset cells to "value", preset is true so would be ok when using SudokuController for fxml

public class Sudoku {
	
	//The board should be representet as a string, 9x9 = 81 chars
	private String board;
	//To keep track of the SudokuCells I use an ArrayList
	private List<ArrayList<SudokuCell>> cells;
	
	
	public Sudoku(String board) {
		this.board = board;
		setup();
	}
	
	//The setup should use the board string and make all the cells for the game
	private void setup() {
		this.cells = new ArrayList<ArrayList<SudokuCell>>();
		int counter = 0;
		for(int row = 0 ; row < 9 ; row ++) {
			this.cells.add(new ArrayList<SudokuCell>());
			for (int col = 0 ; col < 9 ; col ++) {
				char value = this.board.charAt(counter);
				boolean preset = value != '.';
				this.cells.get(row).add(new SudokuCell(value,preset));
				counter++;
			}
		}
	}
	
	//The board would be indexed from row 1-9 and col 1-9
	public SudokuCell getCell(int x, int y) {
		return this.cells.get(x).get(y);
	}
	
	
	public boolean setCell(int x, int y,String value) {
		SudokuCell cell = getCell(x,y);
		boolean check = ! cell.getPreset() && value.length() < 2 && (value.matches("[1-9]") || value.length() == 0);
		if(check) {
			cell.setValue(value.length() == 0 ? ' ':value.charAt(0));
		}
		return check;
	}
	
	

}
