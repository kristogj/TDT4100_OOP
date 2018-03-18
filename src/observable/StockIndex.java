package observable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StockIndex implements StockListener {
	
	private String name;
	private double indeks;
	private Set<Stock> stocks;
	
	public StockIndex(String name, Stock...stocks) {
		this.name = name;
		this.stocks = new HashSet<Stock>();
		Arrays.asList(stocks).stream().forEach(s -> this.stocks.add(s));
		updateIndeks();
	}
	
	public void addStock(Stock stock) {
		this.stocks.add(stock);
		updateIndeks();
	}
	
	public void removeStock(Stock stock) {
		this.stocks.remove(stock);
		updateIndeks();
	}
	
	public double getIndex() {
		return indeks;
	}

	@Override
	public void stockPriceChanged(Stock stock, double oldPrice, double newPrice) {
		updateIndeks();
	}
	
	private void updateIndeks() {
		this.indeks = this.stocks.stream().mapToDouble(s -> s.getPrice()).sum();
	}

}
