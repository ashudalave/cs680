package edu.umb.cs.cs680.hw08;

public class ThreeDObserver implements Observer {

	private StockEvent se;
	
	@Override
	public void update(Observable o, Object arg) {
		this.se = (StockEvent) arg;
		System.out.println("\n3DTicker: "+ se.getTicker());
		System.out.println("3DQuote: "+ se.getQuote());

	}

}
