package edu.neu.csye7374;

import edu.neu.csye7374.Builder.BikeBuilder;
import edu.neu.csye7374.Strategy.OfferStrategy;

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
                + bikeCategory + ", bikeManufacturer=" + (String) bikeManufacturer + " ]";
    }

    public String buyBike() {

        return this.toString() + " is bought!!!!";
    }

    public String rentBike() {
        this.bikePrice = this.bikePrice * 0.05;
        return this.toString() + " is rented!!";
    }

    public double runStrategy() {
        double value = 0;
        switch (BikeDock.usingStrategy) {
            case StudentOfferStrategy:
                value = BikeDock.getAlgorithmMap().get(OfferStrategy.StudentOfferStrategy).discountAmt(this);
                break;
            case ExchangeOfferStrategy:
                value = BikeDock.getAlgorithmMap().get(OfferStrategy.ExchangeOfferStrategy).discountAmt(this);
                break;
            case CoupleOfferStrategy:
                value = BikeDock.getAlgorithmMap().get(OfferStrategy.CoupleOfferStrategy).discountAmt(this);
                break;
            case NewMemberOfferStrategy:
                value = BikeDock.getAlgorithmMap().get(OfferStrategy.NewMemberOfferStrategy).discountAmt(this);
                break;
            default:
                value = bikePrice;
                break;
        }
        return value;
    }

}
