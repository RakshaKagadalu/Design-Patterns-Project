package edu.neu.csye7374.Facade;

import edu.neu.csye7374.BikeAPI;
import edu.neu.csye7374.Observer.BikeOrder;

public class BikeOrderFacade {
	private BikeAPI bike;

	public BikeOrderFacade() {
		super();
	}

	public BikeOrderFacade(BikeAPI bike) {
		super();
		this.setBike(bike);
	}

	public BikeOrderFacade setBike(BikeAPI bike) {
		this.bike = bike;
		return this;
	}

	public BikeAPI getBike() {
		return bike;
	}

	public BikeOrder bikeOrder() {
		BikeOrder order = new BikeOrder();
		BikeDecorator giftdecBike = new GiftDecorator(bike);
		System.out.println(giftdecBike);
		order.addBike(giftdecBike);
		return order;
	}

}
