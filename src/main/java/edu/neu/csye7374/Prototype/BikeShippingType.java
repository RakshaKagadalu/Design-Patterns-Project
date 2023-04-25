package edu.neu.csye7374.Prototype;

public abstract class BikeShippingType implements Cloneable {

	
	private String shippingType;
	private double shippingCost;
	private int shippingId;
	
	public BikeShippingType(int shippingId, String shippingType, double shippingCost) {
		super();
		this.shippingId = shippingId;
		this.shippingType = shippingType;
		this.shippingCost = shippingCost;
	}

	abstract String shippingDetails();



	public String getShippingType() {
		return shippingType;
	}

	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}

	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}
	
	public int getShippingId() {
		return shippingId;
	}

	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Object clone = null;
	      
		try {
			clone = super.clone();   
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
	
	
	
	
	
}
