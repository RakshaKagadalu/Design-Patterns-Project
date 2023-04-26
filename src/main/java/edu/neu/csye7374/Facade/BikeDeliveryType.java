package edu.neu.csye7374.Facade;

public enum BikeDeliveryType {
    Delivery,
    Pickup;

    public static BikeDeliveryType getBikeDeliveryType(String s) {
        switch (s.toLowerCase()) {
            case "delivery":
                return BikeDeliveryType.Delivery;
            case "pickup":
                return BikeDeliveryType.Pickup;
            default:
                return BikeDeliveryType.Pickup;
        }
    }

}
