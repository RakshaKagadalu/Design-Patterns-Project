package edu.neu.csye7374.Command;

import java.util.*;

import edu.neu.csye7374.Bike;
import edu.neu.csye7374.BikeAPI;

public class Invoker {
    private List<Bike> orderList = new ArrayList<>();

    public void takeBikeOrder(Bike order) {
        orderList.add(order);
    }

    public void placeBikeOrders() {
        BuyBikeCommand buyBikeCommand = BuyBikeCommand.getInstance();
        for (Bike order : orderList) {
            System.out.println(buyBikeCommand.setBike(order).execute());
        }
        orderList.clear();
    }

    public void placeBikeOrders(List<Bike> bikeList) {
        for (Bike b : bikeList) {
            orderList.add(b);
        }
        placeBikeOrders();
    }

    public void rentBikeOrders() {
        RentBikeCommand rentBikeCommand = RentBikeCommand.getInstance();
        for (Bike order : orderList) {
            System.out.println(rentBikeCommand.setBike(order)
                    .execute());
        }
        orderList.clear();
    }

    public void rentBikeOrders(List<Bike> bikeList) {
        for (Bike b : bikeList) {
            orderList.add(b);
        }
        rentBikeOrders();
    }

    public List<Bike> getBikeOrderList() {
        return orderList;
    }

    public void setBikeOrderList(List<Bike> orderList) {
        this.orderList = orderList;
    }

}
