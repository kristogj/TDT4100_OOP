package observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmartStock extends Stock{
	
	private Map<StockListener,ArrayList<Double>> intervallLyttere;
	private Map<StockListener,Double> differanceLyttere;
	
	
	public SmartStock(String ticker, double price) {
		super(ticker, price);
		this.intervallLyttere = new HashMap<StockListener,ArrayList<Double>>();
		this.differanceLyttere = new HashMap<StockListener,Double>();
	}
	
	
	public void addStockListener(StockListener lytter, double min, double max) {
		this.intervallLyttere.put(lytter, new ArrayList<Double>(Arrays.asList(min,max)));
	}
	
	public void addStockListener(StockListener lytter, double difference) {
		this.differanceLyttere.put(lytter, difference);
	}
	
	public void setPrice(double price) {
		double oldPrice = this.getPrice();
		super.setPrice(price);
		
		
		//Oppdater alle intervall lyttere
		intervallLyttere.keySet().stream().
		filter(lytter -> (this.getPrice() < intervallLyttere.get(lytter).get(0)) || this.getPrice() > intervallLyttere.get(lytter).get(1)).
		forEach(lytter -> lytter.stockPriceChanged(this, oldPrice, this.getPrice()));
		
		double difference = Math.abs(this.getPrice() - oldPrice);
		
		//Oppdatere alle differanse lyttere
		differanceLyttere.keySet().stream().
		filter(lytter -> difference > this.differanceLyttere.get(lytter)).
		forEach(lytter -> lytter.stockPriceChanged(this, oldPrice, this.getPrice()));
	}
	
}
