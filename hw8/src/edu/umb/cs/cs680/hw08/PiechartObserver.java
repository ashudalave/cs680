package edu.umb.cs.cs680.hw08;

public class PiechartObserver implements Observer {

	private StockEvent se;
	
	@Override
	public void update(Observable o, Object arg) {
		
		this.se = (StockEvent) arg;
		System.out.println("\nPieTicker: "+ se.getTicker());
		System.out.println("PieQuote: "+ se.getQuote());
	}

}
