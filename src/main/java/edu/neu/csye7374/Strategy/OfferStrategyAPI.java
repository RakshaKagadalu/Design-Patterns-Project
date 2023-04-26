package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.Bike;

public interface OfferStrategyAPI {
	public double discountAmt(Bike bike);

	public String discountDesc(Bike bike);
}
