package edu.neu.csye7374.Observer;

public class BikePriceObserver implements CheckoutObserverAPI {

	@Override
	public void update(BikeOrder bikeorder) {
		// TODO Auto-generated method stub
		double orderTotal = bikeorder.getBikeBikeOrderCost();
		if (orderTotal >= 700) {
			bikeorder.setOfferDiscount(30);
		} else if (orderTotal >= 500) {
			bikeorder.setOfferDiscount(15);
		}
	}

}
