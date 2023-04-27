package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.Bike;
import edu.neu.csye7374.BikeAPI;

public class Insurance extends BikeDecorator {
    public Insurance(BikeAPI decoratedBike) {
        super(decoratedBike);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String bikeDescription() {
        // TODO Auto-generated method stub
        return decoratedBike.bikeDescription() + ", Added Insurance to the Order";
    }

    @Override
    public Object getBikeManufacturer() {
        // TODO Auto-generated method stub
        return decoratedBike.getBikeManufacturer();
    }

    public double getBikePrice() {
        Bike b = Bike.class.cast(decoratedBike);
        return b.getBikePrice() + 20;
    }
}
