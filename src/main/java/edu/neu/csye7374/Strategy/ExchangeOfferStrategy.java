package edu.neu.csye7374.Strategy;

public class ExchangeOfferStrategy implements OfferStrategyAPI {

	@Override
	public double discountAmt(Bike bike) {
		// TODO Auto-generated method stub
		double rate = 0.40;
		double offer = bike.getBikePrice() - (bike.getBikePrice() * rate);
		offer = (double) Math.round(offer * 100) / 100;
		return offer;

	}

	@Override
	public String discountDesc(Bike bike) {
		// TODO Auto-generated method stub
		return "40% discount for exchange bike offer added!";
	}
}
