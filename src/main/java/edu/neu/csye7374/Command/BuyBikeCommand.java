package edu.neu.csye7374.Command;

import edu.neu.csye7374.*;

public class BuyBikeCommand implements CommandAPI {
    private static BuyBikeCommand instance;
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

    public Bike getBike() {
        return bike;
    }

    public BuyBikeCommand setBike(Bike bike) {
        this.bike = bike;
        return this;
    }
}