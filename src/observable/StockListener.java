package observable;

public interface StockListener {
	
	//Skal holde lytterene oppdatert på aksjeprisen. Alle lytterene må implementere denne metoden.
	void stockPriceChanged(Stock stock,double oldPrice, double newPrice);
}
