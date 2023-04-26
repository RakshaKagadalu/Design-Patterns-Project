package edu.neu.csye7374.state_DP;

import edu.neu.csye7374.Observer.BikeOrder;

public class BikeConfirmed implements BikeStatusStateAPI {

    private BikeOrder bikeorder;

    public BikeConfirmed(BikeOrder bikeorder) {
        super();
        this.bikeorder = bikeorder;
    }

    @Override
    public void bikeConfirmed_state() {
        System.out.println("Error ... BikeOrder already in CONFIRMED State");
    }

    @Override
    public void bikeDeliveryStatus_state() {
        bikeorder.setState(bikeorder.getBikeOrderDispatched());
        System.out.println("SUCCESS!! BikeOrder DISPATCHED");
    }

    @Override
    public void bikeDelivered_state() {
        System.out.println("Error ... BikeOrder not yet DISPATCHED");
    }

}
