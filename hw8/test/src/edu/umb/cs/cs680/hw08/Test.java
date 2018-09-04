package edu.umb.cs.cs680.hw08;

import java.util.Random;

public class Test {

	@org.junit.Test
	public void test() {
	
		Random rnd = new Random(4);
		PiechartObserver p = new PiechartObserver();
		TableObserver t = new TableObserver();
		ThreeDObserver threeD = new ThreeDObserver();
		StockQuoteObservable stockQuote = new StockQuoteObservable();
		
		stockQuote.addObserver(p);
		stockQuote.addObserver(t);	
		stockQuote.addObserver(threeD);
		
		float quote = 0;
		int i = 0;
		while (i<2) {
			quote = rnd.nextFloat() * 10;
			stockQuote.changeQuote("TESLA", quote);	   
        i++;
		}
		
	}

}
