package observable;

import java.util.HashSet;
import java.util.Set;

public class Stock {
	
	
	private String ticker;
	private double price;
	//Et set med alle lytterene som følger med på denne Stocken
	private Set<StockListener> lyttere;
	
	
	public Stock(String ticker, double price) {
		this.ticker = ticker;
		this.price = price;
		this.lyttere = new HashSet<StockListener>();
	}
	
	public void setPrice(double price) {
		if(price <= 0) {
			throw new IllegalArgumentException();
		}
		//Oppdater alle lytterene
		double oldPrice = this.price;
		this.price = price;
		this.lyttere.stream().forEach(lytter -> lytter.stockPriceChanged(this, oldPrice, price));
		
		
	}
	
	public String getTicker() {
		return ticker;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void addStockListener(StockListener lytter) {
		this.lyttere.add(lytter);
	}
	
	public void removeStockListener(StockListener lytter) {
		this.lyttere.remove(lytter);
	}
	

}
