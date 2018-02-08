package sudoku;



import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
	
	public void initialize() {
		String board = ".....2..38.273.45....6..87.9.8..5367..6...1..4513..9.8.84..3....79.512.62..8.....";
		this.game = new Sudoku(board);
		this.gridCells = grid.getChildren();
		setupBoardView();
	}
	
	public void setupBoardView() {
		for(Node node : gridCells) {
			String pos = node.getId().substring(1);
			int x = Character.getNumericValue(pos.charAt(0));
			int y = Character.getNumericValue(pos.charAt(1));
			String value = game.getCell(x, y).getValue();
			switch (value.length()) {
			//Empty cell "." should just be empty
			case 1: ((TextField) node).setText("");;break;
			//Preset value should not be editable
			case 3: ((TextField) node).setText(value.charAt(1)+"");
			((TextField) node).setEditable(false);
			break;
			default: break;
			}
		}
	}
	
	
	//Update game on selected cell
	@FXML
	public void actionOnCell(ActionEvent event) {
		TextField t = (TextField) event.getSource();
		String pos = t.getId().substring(1);
		int x = Character.getNumericValue(pos.charAt(0));
		int y = Character.getNumericValue(pos.charAt(1));
		String value = t.getText();
		boolean status = game.setCell(x, y, value);
		topText.setText(status ? "That´s legal":"Illegal move!!");
		System.out.println(value);
		System.out.println(status);
	}

}
