package edu.umb.cs.cs680.hw08;

public class StockEvent {
	
	private float quote;
	private String ticker;

	public StockEvent(String ticker, float quote) {
		this.ticker = ticker;
		this.quote = quote;
	}

	public float getQuote() {
		return quote;
	}

	public void setQuote(float quote) {
		this.quote = quote;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

}
