package edu.neu.csye7374.Facade;

public class BikeDeleveryType {

	    public static final BikeDeleveryType DELIVERY = new BikeDeleveryType("delivery");
	    public static final BikeDeleveryType PICKUP = new BikeDeleveryType("pickup");
	    
	    private String type;

	    private BikeDeleveryType(String type) {
	        this.type = type;
	    }

	    public static BikeDeleveryType getBikeDeliveryType(String s) {
	        switch(s.toLowerCase()) {
	            case "delivery":
	                return DELIVERY;
	            case "pickup":
	                return PICKUP;
	            default:
	                return PICKUP;
	        }
	    }

	    public String getType() {
	        return type;
	    }
	}


