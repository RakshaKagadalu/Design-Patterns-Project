package edu.neu.csye7374.Command;

import java.util.*;

import edu.neu.csye7374.Bike;

public class Invoker {
    private List<Bike> orderList = new ArrayList<>();

    public void takeOrder(Bike order) {
        orderList.add(order);
    }

    public void placeOrders() {
        BuyBikeCommand buyBikeCommand = BuyBikeCommand.getInstance();
        for (Bike order : orderList) {
            System.out.println(BuyBikeCommand.setBike(order)
                    .execute());
        }
        orderList.clear();
    }

    public void placeOrders(List<Bike> bikeList) {
        for (Bike b : bikeList) {
            orderList.add(b);
        }
        placeOrders();
    }

    public void rentOrders() {
        RentBikeCommand rentBikeCommand = RentBikeCommand.getInstance();
        for (Bike order : orderList) {
            System.out.println(rentBikeCommand.setBike(order)
                    .execute());
        }
        orderList.clear();
    }

    public void rentOrders(List<Bike> bikeList) {
        for (Bike b : bikeList) {
            orderList.add(b);
        }
        rentOrders();
    }

    public List<Bike> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Bike> orderList) {
        this.orderList = orderList;
    }

}
