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
	
	
	public CryptoController() {
		
	}
	
	public void update() throws IOException{
		ArrayList<Double> btc = crypto.URLReader(BTC);
		ArrayList<Double> ltc = crypto.URLReader(LTC);
		ArrayList<Double> eth = crypto.URLReader(ETH);
		
		System.out.println("hei");
		System.out.println(btc.get(1));
	}
	
	
	public static void main(String[] args) throws IOException {
		CryptoController c = new CryptoController();
		c.update();
	}
}