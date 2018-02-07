package tictactoe;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TicTacToeController {
	
	@FXML
	Label turn,finished;
	
	TicTacToe game;
	
	ArrayList<Button> usedButtons;
	
	public void initialize() {
		this.game = new TicTacToe();
		this.usedButtons = new ArrayList<Button>();
		update();
	}
	
	public void update() {
		char player = game.getCurrentPlayer();
		if(game.isFinished()) {
			if(game.hasWinner()) {
				finished.setText("The Winner is " + game.getLastPlayer() + "!!!");
			}
			else {
				finished.setText("It´s a tie");
			}
		}
		turn.setText("" + player);
	}
	
	@FXML
	public void cellPush(ActionEvent action) {
		Button button = (Button) action.getSource();
		int x = Character.getNumericValue(button.getId().charAt(1));
		int y = Character.getNumericValue(button.getId().charAt(2));
		if(!game.isFinished() && !game.isOccupied(x, y)) {
			usedButtons.add(button);
			game.play(x, y);
			button.setText("" + game.getLastPlayer());
			update();
		}
	}
	
	public void reset() {
		for(Button b : this.usedButtons) {
			b.setText("");
		}
		this.finished.setText("");
		initialize();
	}

}
