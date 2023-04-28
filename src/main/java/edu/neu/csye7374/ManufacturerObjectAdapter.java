package edu.neu.csye7374;

import edu.neu.csye7374.BikeAPI;

public class ManufacturerObjectAdapter implements BikeAPI {

    private Manufacturer manufacturer;
    private BikeAPI bike;

    public ManufacturerObjectAdapter(BikeAPI bike, Manufacturer adaptee) {
        this.bike = bike;
        this.manufacturer = adaptee;
        setbikeManufacturer(adaptee.getManufacturerName());
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
        return "###### " + manufacturer + "#####, ##### Bike :" + bike + "#####";
    }

    @Override
    public double getBikePrice() {
        // TODO Auto-generated method stub
        return bike.getBikePrice();
    }

    @Override
    public int noOfBikesRented() {
        // TODO Auto-generated method stub
        return bike.noOfBikesRented();
    }

    @Override
    public void setbikeManufacturer(String bikeManufacturer) {
        // TODO Auto-generated method stub
        this.bike.setbikeManufacturer(bikeManufacturer);
    }

}
