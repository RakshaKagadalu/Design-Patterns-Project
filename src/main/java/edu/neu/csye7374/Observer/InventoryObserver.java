package edu.neu.csye7374.Observer;


public class InventoryObserver implements CheckoutObserverAPI {

	@Override
	public void update(BikeOrder bikeorder) {
		// TODO Auto-generated method stub
		if(bikeorder.getDeliveryType()==BikeShippingType.Delivery) {
			int stock=bikeorder.getBikeCount();
			if(stock<=7) {
				bikeorder.setDeliveryCost(20);
			}else  {
				bikeorder.setDeliveryCost(30 + (stock-9)*2.5);
			}
		}
	}

}
