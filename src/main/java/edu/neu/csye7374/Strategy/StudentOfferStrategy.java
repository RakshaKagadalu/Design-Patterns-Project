package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.Bike;

public class StudentOfferStrategy implements OfferStrategyAPI {

	@Override
	public double discountAmt(Bike bike) {
		// TODO Auto-generated method stub
		double rate = 0.50;
		double offer = bike.getBikePrice() - (bike.getBikePrice() * rate);
		offer = (double) Math.round(offer * 100) / 100;
		return offer;

	}

	@Override
	public String discountDesc(Bike bike) {
		// TODO Auto-generated method stub
		return "50% discount for students added!";
	}

}
