package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.*;

public class GiftDecorator extends BikeDecorator {

    public GiftDecorator(BikeAPI decoratedBook) {
        super(decoratedBook);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String bikeDescription() {
        // TODO Auto-generated method stub
        return decoratedBook.bikeDescription() + "..Wrapped for gift along with a pen";
    }

    @Override
    public Object getBikeManufacturer() {
        // TODO Auto-generated method stub
        return decoratedBook.getBikeManufacturer();
    }

    public double getBikePrice() {
        Bike b = Bike.class.cast(decoratedBook);
        return b.getBikePrice() + 10;
    }

}
