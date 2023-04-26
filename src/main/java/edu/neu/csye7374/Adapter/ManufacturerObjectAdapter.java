package edu.neu.csye7374.Adapter;

import edu.neu.csye7374.BikeAPI;

public class ManufacturerObjectAdapter implements BikeAPI {

    private Manufacturer manufacturer;
    private BikeAPI bike;

    public ManufacturerObjectAdapter(BikeAPI bike, Manufacturer adaptee) {
        this.bike = bike;
        this.manufacturer = adaptee;
    }

    @Override
    public String bikeDescription() {
        // TODO Auto-generated method stub
        return bike.bikeDescription();
    }

    @Override
    public Object getBikeManufacturer() {
        // TODO Auto-generated method stub
        return Manufacturer.class.cast(manufacturer);
    }

    @Override
    public String toString() {
        return "[" + manufacturer + "], [bike=" + bike + "]";
    }

    @Override
    public double getBikePrice() {
        // TODO Auto-generated method stub
        return bike.getBikePrice();
    }

    @Override
    public int noOfBikesRented() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'noOfBikesRented'");
    }

}
