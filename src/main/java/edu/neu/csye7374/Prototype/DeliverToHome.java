package edu.neu.csye7374.Prototype;

public class DeliverToHome extends BikeShippingType {

	public DeliverToHome(int shippingId, String shippingType, double shippingCost) {
		super(shippingId, shippingType, shippingCost);
		// TODO Auto-generated constructor stub
	}

	@Override
	String shippingDetails() {
		// TODO Auto-generated method stub
		return  "You have selected the home delivery option !";
	}

}
