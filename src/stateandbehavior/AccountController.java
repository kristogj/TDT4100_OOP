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
	Button depositButton, addIntrestButton, setIntrestButton, clearButton;
	
	public AccountController() {
		
	}
	
	public void deposit() {
		Double value = Double.valueOf(depositField.getText());
		account.deposit(value);
		balance.setText(Double.toString(account.getBalance()));
	}
	
	public void setIntrest() {
		Double value = Double.valueOf(intrestField.getText());
		account.setInterestRate(value);
		intrestRate.setText(Double.toString(account.getInterestRate()));
	}
	
	public void addIntrest() {
		account.addInterest();
		balance.setText(Double.toString(account.getBalance()));
	}
	
	public void clear() {
		account.balance = 0.0;
		account.intrestRate = 0.0;
		balance.setText(Double.toString(account.getBalance()));
		intrestRate.setText(Double.toString(account.getInterestRate()));
	}
	
	
	
}
