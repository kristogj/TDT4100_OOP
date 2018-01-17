package cryptoproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CryptoController {
	
	Crypto crypto = new Crypto();
	
	static String BTC = "https://api.coinmarketcap.com/v1/ticker/bitcoin/?convert=NOK";
	static String LTC = "https://api.coinmarketcap.com/v1/ticker/litecoin/?convert=NOK";
	static String ETH = "https://api.coinmarketcap.com/v1/ticker/ethereum/?convert=NOK";
	
	ArrayList<String> coins = new ArrayList<String>(Arrays.asList(BTC,LTC,ETH));
	
	@FXML
	Button updateButton;
	
	@FXML
	Label btcusd, ltcusd, ethusd, btcnok, ltcnok, ethnok;
	
	
	public void update() throws IOException{
		ArrayList<Double> btc = crypto.URLReader(BTC);
		ArrayList<Double> ltc = crypto.URLReader(LTC);
		ArrayList<Double> eth = crypto.URLReader(ETH);
		
//		btcusd.setText(Double.toString(btc.get(0)));
//		ltcusd.setText(Double.toString(ltc.get(0)));
//		ethusd.setText(Double.toString(eth.get(0)));
//		btcnok.setText("hei");
//		ltcnok.setText(Double.toString(ltc.get(1)));
//		ethnok.setText(Double.toString(eth.get(1)));
//		
//		System.out.println(Double.toString(btc.get(1)));
	}

}
