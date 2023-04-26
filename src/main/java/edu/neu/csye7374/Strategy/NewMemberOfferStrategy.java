package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.Bike;

public class NewMemberOfferStrategy implements OfferStrategyAPI {

	@Override
	public double discountAmt(Bike bike) {
		// TODO Auto-generated method stub
		double rate = 0.30;
		double offer = bike.getBikePrice() - (bike.getBikePrice() * rate);
		offer = (double) Math.round(offer * 100) / 100;
		return offer;

	}

	@Override
	public String discountDesc(Bike bike) {
		// TODO Auto-generated method stub
		return "30% discount for New member offer added!";
	}
}
