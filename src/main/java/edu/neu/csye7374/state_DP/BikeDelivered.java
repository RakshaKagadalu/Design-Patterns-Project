package edu.neu.csye7374.state_DP;

import edu.neu.csye7374.Observer.BikeOrder;

public class BikeDelivered implements BikeStatusStateAPI {
    private BikeOrder order;

    public BikeDelivered(BikeOrder order) {
        super();
        this.order = order;
    }

    @Override
    public void bikeConfirmed_state() {
        System.out.println("Error ... BikeOrder already DELIVERED");
    }

    @Override
    public void bikeDeliveryStatus_state() {
        System.out.println("Error ... BikeOrder already DELIVERED");
    }

    @Override
    public void bikeDelivered_state() {
        System.out.println("Error ... BikeOrder already DELIVERED");
    }
}
