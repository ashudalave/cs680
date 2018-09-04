package edu.umb.cs.cs680.hw08;

public class StockQuoteObservable extends Observable {
	
	private StockEvent se;
	private String ticker;
	private float quote;

	public void changeQuote(String t, float q) {
		this.ticker = t; 
		this.quote = q; 
		this.se = new StockEvent(ticker, quote);
		this.setChanged();
		this.notifyObservers(se);
	}
}
