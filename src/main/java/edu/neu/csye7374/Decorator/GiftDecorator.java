package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.*;

public class GiftDecorator extends BikeDecorator {

    public GiftDecorator(BikeAPI decoratedBike) {
        super(decoratedBike);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String bikeDescription() {
        // TODO Auto-generated method stub
        return decoratedBike.bikeDescription() + "..Wrapped for gift along with a pen";
    }

    @Override
    public Object getBikeManufacturer() {
        // TODO Auto-generated method stub
        return decoratedBike.getBikeManufacturer();
    }

    public double getBikePrice() {
        Bike b = Bike.class.cast(decoratedBike);
        return b.getBikePrice() + 10;
    }

}
