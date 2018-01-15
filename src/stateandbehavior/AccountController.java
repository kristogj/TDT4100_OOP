package stateandbehavior;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import stateandbehavior.Account;


public class AccountController {
	
	Account account = new Account();
	
	@FXML
	TextField depositField, intrestField;
	
	@FXML
	Label balance, intrestRate;
	
	@FXML
	Button depositButton, addIntrestButton, setIntrestButton;
	
	public AccountController() {
		
	}
	
	public void deposit() {
		int value = Integer.valueOf(depositField.getText());
		account.deposit(value);
		balance.setText(Double.toString(account.getBalance()));
	}
	
	public void setIntrest() {
		int value = Integer.valueOf(intrestField.getText());
		account.setInterestRate(value);
		intrestRate.setText(Integer.toString(account.getInterestRate()));
	}
	
	public void addIntrest() {
		account.addInterest();
		balance.setText(Double.toString(account.getBalance()));
	}
	
	
	
}
