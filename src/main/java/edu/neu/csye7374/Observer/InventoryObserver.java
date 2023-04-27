package edu.neu.csye7374.Observer;

import edu.neu.csye7374.Facade.BikeDeliveryType;

public class InventoryObserver implements CheckoutObserverAPI {

	@Override
	public void update(BikeOrder bikeorder) {
		// TODO Auto-generated method stub
		if (bikeorder.getBikeDeliveryType() == BikeDeliveryType.Delivery) {
			int count = bikeorder.getBikeCount();
			if (count <= 5) {
				bikeorder.setDeliveryCost(20);
			} else {
				bikeorder.setDeliveryCost((count - 5) + 10 * 3);
			}
		}
	}

}
