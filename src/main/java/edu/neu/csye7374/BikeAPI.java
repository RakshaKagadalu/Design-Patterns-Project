package edu.neu.csye7374;

public interface BikeAPI {
    String bikeDescription();

    Object getBikeManufacturer();

    void setbikeManufacturer(String bikeManufacturer);

    int noOfBikesRented();

    double getBikePrice();

}
