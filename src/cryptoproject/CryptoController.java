package cryptoproject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CryptoController {
	
	Crypto crypto;
	DecimalFormat numFormat = new DecimalFormat("#.00");
	
	static String BTC = "https://api.coinmarketcap.com/v1/ticker/bitcoin/?convert=NOK";
	static String LTC = "https://api.coinmarketcap.com/v1/ticker/litecoin/?convert=NOK";
	static String ETH = "https://api.coinmarketcap.com/v1/ticker/ethereum/?convert=NOK";
	
	ArrayList<String> api;
	
	@FXML
	Button updateButton;
	
	@FXML
	Label btcusd, btcnok, ltcusd, ltcnok, ethusd, ethnok;
	
	@FXML
	Label btcusdWallet, btcnokWallet, ltcusdWallet, ltcnokWallet, ethusdWallet, ethnokWallet;
	
	@FXML
	TextField btcfield, ltcfield, ethfield;
	
	
	public CryptoController() {
		this.crypto = new Crypto();
		this.api = new ArrayList<String>(Arrays.asList(BTC,LTC,ETH));
		
	}

	
	public void update() throws IOException{
		ArrayList<Label> tickers = new ArrayList<Label>(Arrays.asList(btcusd, btcnok, ltcusd, ltcnok, ethusd, ethnok));
		ArrayList<Label> wallets = new ArrayList<Label>(Arrays.asList(btcusdWallet, btcnokWallet, ltcusdWallet, ltcnokWallet, ethusdWallet, ethnokWallet));
		ArrayList<TextField> walletFields = new ArrayList<TextField>(Arrays.asList(btcfield, ltcfield, ethfield));
		
		for (int x = 0; x < this.api.size();x++) {
			ArrayList<Double> values = this.crypto.URLReader(this.api.get(x));
			//Update Tickers
			tickers.get(2*x).setText(numFormat.format(values.get(0)));
			tickers.get(2*x+1).setText(numFormat.format(values.get(1)));
			
			//Update wallets
			wallets.get(2*x).setText(numFormat.format(values.get(0)*Double.parseDouble(walletFields.get(x).getText())));
			wallets.get(2*x+1).setText(numFormat.format(values.get(1)*Double.parseDouble(walletFields.get(x).getText())));
		}
		
	}
	
	
	
}