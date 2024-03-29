package edu.neu.csye7374.Builder;

import edu.neu.csye7374.Bike;
import edu.neu.csye7374.Bike;
import edu.neu.csye7374.BikeCategory;

import edu.neu.csye7374.Factory.*;

public class BikeBuilder implements BuilderAPI {

    private int bikeId;
    private String bikeName;
    private double bikePrice;
    private BikeCategory bikeCategory;
    private String bikeManufacturer;

    public String getBikeManufacturer() {
        return bikeManufacturer;
    }

    public void setBikeAuthor(String bikeManufacturer) {
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

    public void setBikePrice(double bikePrice) {
        this.bikePrice = bikePrice;
    }

    public BikeCategory getBikeCategory() {
        return bikeCategory;
    }

    public void setBikeCategory(BikeCategory bikeCategory) {
        this.bikeCategory = bikeCategory;
    }

    public BikeBuilder(int bikeId, String bikeName, double bikePrice, BikeCategory bikeCategory,
            String bikeManufacturer) {
        super();
        this.bikeId = bikeId;
        this.bikeName = bikeName;
        this.bikePrice = bikePrice;
        this.bikeCategory = bikeCategory;
        this.bikeManufacturer = bikeManufacturer;
    }

    public BikeBuilder(String s) {
        String[] tokens = s.split(",");
        this.bikeId = Integer.parseInt(tokens[0]);
        this.bikeName = tokens[1];
        this.bikePrice = Double.parseDouble(tokens[2]);
        this.bikeCategory = BikeCategory.getBikeCategory(tokens[3]);
        this.bikeManufacturer = tokens[4];
    }

    @Override
    public Bike build() {
        // TODO Auto-generated method stub
        return BikeFactory.getInstance().getObject(this);
    }
}
