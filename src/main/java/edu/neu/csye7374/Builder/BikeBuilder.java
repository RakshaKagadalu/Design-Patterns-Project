package edu.neu.csye7374.Builder;

import neu.csye7374.src.Bike;
import neu.csye7374.src.Bike;
import neu.csye7374.src.BikeCategory;
import neu.csye7374.src.ConvertUtility;
import neu.csye7374.src.Factory_Pattern.*;

public class BikeBuilder implements BuilderAPI {

    private int bikeId;
    private String bikeName;
    private double bikePrice;
    private BikeCategory bikeCategory;
    private String bikeManufacturer;

    public String getBikeManufacturer() {
        return bookAuthor;
    }

    public void setBikeAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBikeId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBikeName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBikePrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public BikeCategory getBikeCategory() {
        return bookCategory;
    }

    public void setBookCategory(BikeCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public BikeBuilder(int bookId, String bookName, double bookPrice, BikeCategory bookCategory, String bookAuthor) {
        super();
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookCategory = bookCategory;
        this.bookAuthor = bookAuthor;
    }

    public BikeBuilder(String s) {
        String[] tokens = s.split(",");
        this.bookId = ConvertUtility.StringToInt(tokens[0]);
        this.bookName = tokens[1];
        this.bookPrice = ConvertUtility.StringToDouble(tokens[2]);
        this.bookCategory = BikeCategory.getBikeCategory(tokens[3]);
        this.bookAuthor = tokens[4];
    }

    @Override
    public Bike build() {
        // TODO Auto-generated method stub
        return BookFactory.getInstance().getObject(this);
    }

}
