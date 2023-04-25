package edu.neu.csye7374.Prototype;

public class CurbSidePickUp extends BikeShippingType{

	public CurbSidePickUp(int shippingId, String shippingType, double shippingCost) {
		super(shippingId, shippingType, shippingCost);
		// TODO Auto-generated constructor stub
	}

	@Override
	String shippingDetails() {
		// TODO Auto-generated method stub
		return "You have selected the curb side pick up option!";
	}
	 
}
