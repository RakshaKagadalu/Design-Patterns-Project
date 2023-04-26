package edu.neu.csye7374.Adapter;

import neu.csye7374.src.BikeAPI;

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
    public int noOfBikesReleased() {
        // TODO Auto-generated method stub
        return manufacturer.getNoOfBooksPublished();
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

}
