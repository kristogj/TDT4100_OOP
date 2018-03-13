package sudoku;



import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;



public class SudokuController {
	
	private ObservableList<Node> gridCells;
	private Sudoku game;
	
	
	
	@FXML
	GridPane grid;
	
	@FXML
	Label topText;
	
	private List<SudokuAction> undoStack, redoStack;
	
	
	
	public void initialize() {
		String board = ".....2..38.273.45....6..87.9.8..5367..6...1..4513..9.8.84..3....79.512.62..8.....";
		System.out.println(board);
		this.undoStack = new ArrayList<SudokuAction>();
		this.redoStack = new ArrayList<SudokuAction>();
		this.game = new Sudoku(board);
		this.gridCells = grid.getChildren();
		System.out.println(gridCells);
		setupBoardView();
	}
	
	
	
	public void setupBoardView() {
		for(Node node : gridCells) {
			
			int x = GridPane.getRowIndex(node) == null ? 0 : GridPane.getRowIndex(node);
			int y = GridPane.getColumnIndex(node) == null ? 0 : GridPane.getColumnIndex(node);
			
			SudokuCell cell = game.getCell(x, y);
			String value = cell.getValue().equals(".") ? "" : cell.getValue();
			((TextField) node).setText(value);
			if(cell.getPreset()) {
				((TextField) node).setEditable(false);
			}	
		}
	}
	
	private void addNewMove(SudokuAction action) {
		this.undoStack.add(action);
	}
	
	
	private void doSudokuAction(TextField t, String value) {
		int x = GridPane.getRowIndex(t) == null ? 0 : GridPane.getRowIndex(t);
		int y = GridPane.getColumnIndex(t) == null ? 0 : GridPane.getColumnIndex(t);
		boolean status = game.setCell(x, y, value);
		t.setText(value);
		System.out.println(x + " " + y + " ");
		topText.setText(status ? "That´s legal":"Illegal move!!");
	}
	
	@FXML
	public void undo() {
		if(undoStack.isEmpty()) {
			return;
		}
		SudokuAction sa = undoStack.remove(undoStack.size()-1);
		redoStack.add(sa);
		doSudokuAction(sa.getField(),"");
	}
	
	@FXML
	public void redo() {
		if (redoStack.isEmpty()) {
			return;
		}
		SudokuAction sa = redoStack.remove(redoStack.size()-1);
		undoStack.add(sa);
		doSudokuAction(sa.getField(),sa.getValue());
	}
	
	//Update game on selected cell
	@FXML
	public void actionOnCell(ActionEvent event) {
		TextField t = (TextField) event.getSource();
		int x = GridPane.getRowIndex(t) == null ? 0 : GridPane.getRowIndex(t);
		int y = GridPane.getColumnIndex(t) == null ? 0 : GridPane.getColumnIndex(t);
		String value = t.getText();
		boolean status = game.setCell(x, y, value);
		//add move to undoStack
		addNewMove(new SudokuAction(t,value));
		System.out.println(x + " " + y + " ");
		topText.setText(status ? "That´s legal":"Illegal move!!");
	}
	
	public static void main(String[] args) {
		List<Integer> ii = new ArrayList<Integer>();
		
	}
	
	

}
