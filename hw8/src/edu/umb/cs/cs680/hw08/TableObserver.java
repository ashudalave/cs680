package edu.umb.cs.cs680.hw08;

public class TableObserver implements Observer {

	private StockEvent se;
	
	@Override
	public void update(Observable o, Object arg) {
		this.se = (StockEvent) arg;
		System.out.println("\nTableTicker: "+ se.getTicker());
		System.out.println("TableQuote: "+ se.getQuote());

	}

}
