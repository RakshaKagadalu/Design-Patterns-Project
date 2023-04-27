package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.*;;

public class BikeDecorator implements BikeAPI {
	protected BikeAPI decoratedBike;

	public BikeDecorator(BikeAPI decoratedBike) {
		this.decoratedBike = decoratedBike;
	}

	@Override
	public String bikeDescription() {
		// TODO Auto-generated method stub
		return decoratedBike.bikeDescription();
	}

	@Override
	public int noOfBikesRented() {
		// TODO Auto-generated method stub
		return decoratedBike.noOfBikesRented();
	}

	public BikeAPI getDecoratedBike() {
		return this.decoratedBike;
	}

	@Override
	public String toString() {
		return "BikeDecorator [bikeDescription :" + bikeDescription() + ", "
				+ " $ " + getDecoratedBike() + " $";
	}

	@Override
	public Object getBikeManufacturer() {
		return this.decoratedBike.getBikeManufacturer();
	}

	@Override
	public double getBikePrice() {
		// TODO Auto-generated method stub
		return this.decoratedBike.getBikePrice();
	}
}
