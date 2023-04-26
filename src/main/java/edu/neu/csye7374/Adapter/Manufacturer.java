package edu.neu.csye7374.Adapter;

//import edu.neu.csye7374.Factory_Pattern.EmployeeFactory;

public class Manufacturer implements Cloneable {
    private String manufacturerName;
    private int manufacturingYear;
    private int manufacturingYeanoOfBikesReleasedr;
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

    private Manufacturer(String manufacturerName, int manufacturingYear, int manufacturingYeanoOfBikesReleasedr) {
        super();
        this.manufacturerName = manufacturerName;
        this.manufacturingYear = manufacturingYear;
        this.manufacturingYeanoOfBikesReleasedr = manufacturingYeanoOfBikesReleasedr;
    }

    public String getAuthorName() {
        return manufacturerName;
    }

    public Manufacturer setAuthorName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
        return this;
    }

    public int getAge() {
        return manufacturingYear;
    }

    public Manufacturer setAge(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
        return this;
    }

    public int getNoOfBikesReleased() {
        return manufacturingYeanoOfBikesReleasedr;
    }

    public Manufacturer setNoOfBikesReleased(int manufacturingYeanoOfBikesReleasedr) {
        this.manufacturingYeanoOfBikesReleasedr = manufacturingYeanoOfBikesReleasedr;
        return this;
    }

    @Override
    public String toString() {
        return "Author [manufacturerName=" + manufacturerName + ", manufacturingYear=" + manufacturingYear
                + ", manufacturingYeanoOfBikesReleasedr=" + manufacturingYeanoOfBikesReleasedr + "]";
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
