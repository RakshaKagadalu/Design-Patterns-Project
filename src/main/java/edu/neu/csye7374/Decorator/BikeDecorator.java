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
	public int noOfBikesReleased() {
		// TODO Auto-generated method stub
		return decoratedBike.noOfBikesReleased();
	}

	public BikeAPI getDecoratedBike() {
		return this.decoratedBike;
	}

	@Override
	public String toString() {
		return "BikeDecorator [bikeDescription()=" + bikeDescription() + ", noOfBikesReleased()="
				+ noOfBikesReleased() + ", getDecoratedBike()=" + getDecoratedBike() + "]";
	}
}
