package edu.neu.csye7374;

import edu.neu.csye7374.Builder.BikeBuilder;
import edu.neu.csye7374.Strategy_Pattern.DiscountStrategy;

public class Bike implements BikeAPI {

    public int bikeId;
    public String bikeName;
    public double bikePrice;
    public BikeCategory bikeCategory;
    public Object bikeManufacturer;

    public Bike(BikeBuilder builder) {
        super();
        this.bikeId = builder.getBikeId();
        this.bikeName = builder.getBikeName();
        this.bikePrice = builder.getBikePrice();
        this.bikeCategory = builder.getBikeCategory();
        this.bikeManufacturer = builder.getBikeManufacturer();
    }

    public Object getBikeManufacturer() {
        return String.class.cast(bikeManufacturer);
    }

    public void setbikeManufacturer(String bikeManufacturer) {
        this.bikeManufacturer = bikeManufacturer;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public double getBikePrice() {
        return bikePrice;
    }

    public void setBikePrice(double bikekPrice) {
        this.bikePrice = bikePrice;
    }

    public BikeCategory getBikeCategory() {
        return bikeCategory;
    }

    public void setBikeCategory(BikeCategory bikeCategory) {
        this.bikeCategory = bikeCategory;
    }

    @Override
    public String bikeDescription() {
        // TODO Auto-generated method stub
        return this.bikeName + ", category : " + this.bikeCategory;
    }

    @Override
    public int noOfBikesRented() {
        // TODO Auto-generated method stub
        return (int) Math.random() * 5;
    }

    @Override
    public String toString() {
        return "Bike [bikeId=" + bikeId + ", bikeName=" + bikeName + ", bikePrice=" + bikePrice + ", bikeCategory="
                + bikeCategory + ", bikeManufacturer=" + (String) bikeManufacturer + "]";
    }

    public String buyBike() {

        return this.bikeName + " is bought";
    }

    public String rentBike() {
        this.bikePrice = this.bikePrice * 0.75;
        return this.bikeId + " - " + this.bikeName + " is rented";
    }

    public double runStrategy() {
        double value = 0;
        switch (BikeDock.usingStrategy) {
            case EmployeeDiscount:
                value = BikeDock.getAlgorithmMap().get(DiscountStrategy.EmployeeDiscount).discountPrice(this);
                break;
            case StudentDiscount:
                value = BikeDock.getAlgorithmMap().get(DiscountStrategy.StudentDiscount).discountPrice(this);
                break;
            default:
                value = bikePrice;
                break;
        }
        return value;
    }

}
