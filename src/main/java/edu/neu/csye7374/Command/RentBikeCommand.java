package edu.neu.csye7374.Command;

import edu.neu.csye7374.Bike;

public class RentBikeCommand implements CommandAPI {
    private static RentBikeCommand instance;
    private Bike bike;

    private RentBikeCommand() {
        super();
    }

    public static synchronized RentBikeCommand getInstance() {
        if (instance == null) {
            instance = new RentBikeCommand();
        }
        return instance;
    }

    @Override
    public String execute() {
        return bike.rentBike();
    }

    public Bike getBike() {
        return bike;
    }

    public RentBikeCommand setBike(Bike bike) {
        this.bike = bike;
        return this;
    }

}
