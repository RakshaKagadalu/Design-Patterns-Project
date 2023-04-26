package edu.neu.csye7374.Factory;

import edu.neu.csye7374.Bike;

public class BikeFactory implements BikeFactoryAPI<Bike> {

	private static BikeFactory instance = new BikeFactory(); // Eager Singleton Factory Class

	private BikeFactory() {
		super();
	}

	public synchronized static BikeFactory getInstance() {
		return instance;
	}

	@Override
	public Bike getObject(BuilderAPI<Bike> builder) {
		// TODO Auto-generated method stub
		BikeBuilder bikeBuilder = (BikeBuilder) builder;
		return new Bike(bikeBuilder);
	}

}
