package edu.neu.csye7374.Adapter;

//import edu.neu.csye7374.Factory_Pattern.EmployeeFactory;

public class Manufacturer implements Cloneable {
    private String manufacturerName;
    private int manufacturingYear;
    private int noOfBikesReleased;
    private static Manufacturer instance;

    public Manufacturer() {
        super();
    }

    public static synchronized Manufacturer getInstance() {
        if (instance == null) {
            instance = new Manufacturer();
        }
        return instance;
    }

    private Manufacturer(String manufacturerName, int manufacturingYear, int noOfBikesReleased) {
        super();
        this.manufacturerName = manufacturerName;
        this.manufacturingYear = manufacturingYear;
        this.noOfBikesReleased = noOfBikesReleased;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public Manufacturer setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
        return this;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public Manufacturer setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
        return this;
    }

    public int getNoOfBikesReleased() {
        return noOfBikesReleased;
    }

    public Manufacturer setNoOfBikesReleased(int noOfBikesReleased) {
        this.noOfBikesReleased = noOfBikesReleased;
        return this;
    }

    @Override
    public String toString() {
        return "Author [manufacturerName=" + manufacturerName + ", manufacturingYear=" + manufacturingYear
                + ", NumberOfBikesReleasedr=" + noOfBikesReleased + "]";
    }

    @Override
    public Manufacturer clone() {
        // TODO Auto-generated method stub
        Manufacturer clone = null;

        try {
            clone = (Manufacturer) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
