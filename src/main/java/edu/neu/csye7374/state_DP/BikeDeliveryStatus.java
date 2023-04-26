package edu.neu.csye7374.state_DP;

import edu.neu.csye7374.Observer.BikeOrder;

public class BikeDeliveryStatus implements BikeStatusStateAPI {

    private BikeOrder order;

    public BikeDeliveryStatus(BikeOrder order) {
        super();
        this.order = order;
    }

    @Override
    public void bikeConfirmed_state() {
        System.out.println("Error ... BikeOrder already CONFIRMED");
    }

    @Override
    public void bikeDeliveryStatus_state() {
        System.out.println("Error ... BikeOrder already in DISPATCH state");
    }

    @Override
    public void bikeDelivered_state() {
        order.setState(order.getBikeOrderDelivered());
        System.out.println("SUCCESS!! BikeOrder successfully DELIVERED");
    }
}
