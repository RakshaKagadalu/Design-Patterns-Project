package edu.neu.csye7374.Command;

import edu.neu.csye7374.*;

public class BuyBikeCommand implements CommandAPI {
    private static BuyBikeCommand instance; // Lazy Singleton Factory Class
    private Bike bike;

    private BuyBikeCommand() {
        super();
    }

    public static synchronized BuyBikeCommand getInstance() {
        if (instance == null) {
            instance = new BuyBikeCommand();
        }
        return instance;
    }

    @Override
    public String execute() {
        return bike.buyBike();
    }

    public Bike getBook() {
        return bike;
    }

    public BuyBikeCommand setBook(Bike bike) {
        this.bike = bike;
        return this;
    }
}