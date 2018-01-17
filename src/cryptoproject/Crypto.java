package cryptoproject;

import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

import jdk.internal.jline.internal.InputStreamReader;

import java.io.*;

public class Crypto {
	
	static String btc = "https://api.coinmarketcap.com/v1/ticker/bitcoin/?convert=NOK";
	
	
	public Crypto() {
		
	}
	
	public ArrayList<Double> URLReader(String link) throws IOException {
		URL url = new URL(link);
		Scanner s = new Scanner(url.openStream());
		ArrayList<Double> list = new ArrayList<Double>();
		Double coinUSD = 0.0;
		Double coinNOK = 0.0;
		while(s.hasNext()) {
			String text = s.next();
			if (text.contains("price_usd")) {
				String str = s.next().replaceAll("\",", "").substring(1);
				coinUSD = Double.valueOf(str);
				list.add(coinUSD);
				
			}
			else if (text.contains("price_nok")) {
				String str = s.next().replaceAll("\",", "").substring(1);
				coinNOK = Double.valueOf(str);
				list.add(coinNOK);
			}
		}
		s.close();
		return list;
	}
	
	public static void main(String[] args) throws IOException {
		Crypto crypto = new Crypto();
		System.out.println(crypto.URLReader(btc));
	}
	
	

}
