package edu.neu.csye7374.Observer;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.BikeAPI;
import edu.neu.csye7374.Facade.BikeDeliveryType;
import edu.neu.csye7374.Prototype.BikeShippingType;
import edu.neu.csye7374.state_DP.BikeConfirmed;
import edu.neu.csye7374.state_DP.BikeDelivered;
import edu.neu.csye7374.state_DP.BikeDeliveryStatus;
import edu.neu.csye7374.state_DP.BikeStatusStateAPI;

public class BikeOrder implements BikeStatusStateAPI {

	private int bikeId;
	private double bikeBikeOrderCost = 0;
	private int bikeCount = 0;
	private double offerDiscount = 0;
	private double shippingCost;
	private BikeDeliveryType deliveryType;
	private static int counter = 0;
	private List<CheckoutObserverAPI> observers = new ArrayList<>();
	private List<BikeAPI> bikeList = new ArrayList<>();

	{
		observers.add(new BikePriceObserver());
		observers.add(new InventoryObserver());
	}

	private BikeStatusStateAPI orderConfirmed = new BikeConfirmed(this);
	private BikeStatusStateAPI orderDispatched = new BikeDeliveryStatus(this);
	private BikeStatusStateAPI orderDelivered = new BikeDelivered(this);
	private BikeStatusStateAPI state;

	public BikeOrder() {
		super();
		this.bikeId = ++counter;
		this.deliveryType = BikeDeliveryType.Pickup;
		this.state = getBikeOrderConfirmed();
	}

	public BikeOrder(double orderCost, int bikeCount, double shippingCost, BikeDeliveryType deliveryType) {
		super();
		this.bikeId = ++counter;
		this.bikeBikeOrderCost = orderCost;
		this.bikeCount = bikeCount;
		this.deliveryType = deliveryType;

		if (deliveryType == BikeDeliveryType.Pickup) {
			this.shippingCost = 0;
		} else {
			this.shippingCost = shippingCost;
		}
		this.state = getBikeOrderConfirmed();
	}

	public void addBike(BikeAPI Bike) {
		bikeList.add(Bike);
		bikeBikeOrderCost += Bike.getBikePrice();
		bikeCount++;
		observers.forEach(o -> o.update(this));
	}

	public boolean removeBike(BikeAPI Bike) {
		if (bikeList.remove(Bike)) {
			return true;
		}
		return false;
	}

	public BikeStatusStateAPI getBikeOrderConfirmed() {
		return orderConfirmed;
	}

	public void setBikeOrderConfirmed(BikeStatusStateAPI orderConfirmed) {
		orderConfirmed = orderConfirmed;
	}

	public BikeStatusStateAPI getBikeOrderDelivered() {
		return orderDelivered;
	}

	public void setBikeOrderDelivered(BikeStatusStateAPI orderDelivered) {
		orderDelivered = orderDelivered;
	}

	public BikeStatusStateAPI getBikeOrderDispatched() {
		return orderDispatched;
	}

	public void setBikeOrderDispatched(BikeStatusStateAPI orderDispatched) {
		orderDispatched = orderDispatched;
	}

	public BikeStatusStateAPI getState() {
		return state;
	}

	public void setState(BikeStatusStateAPI state) {
		this.state = state;
	}

	public List<BikeAPI> getBikeList() {
		return bikeList;
	}

	public void setBikeList(List<BikeAPI> BikeList) {
		this.bikeList = BikeList;
	}

	public String getBikeListString() {
		StringBuilder sb = new StringBuilder();
		for (BikeAPI b : bikeList) {
			sb.append(b);
			sb.append("; ");
		}
		return sb.toString();
	}

	public BikeDeliveryType getBikeDeliveryType() {
		return deliveryType;
	}

	public void setBikeDeliveryType(BikeDeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		BikeOrder.counter = counter;
	}

	public List<CheckoutObserverAPI> getObservers() {
		return observers;
	}

	public void setObservers(List<CheckoutObserverAPI> observers) {
		this.observers = observers;
	}

	public void setBikeCount(int bikeCount) {
		this.bikeCount = bikeCount;
	}

	public double getBikeBikeOrderCost() {
		return bikeBikeOrderCost;
	}

	public void attach(CheckoutObserverAPI observer) {
		observers.add(observer);
	}

	public void detach(CheckoutObserverAPI observer) {
		observers.remove(observer);
	}

	public BikeOrder(int id) {
		this.bikeId = id;
	}

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int id) {
		this.bikeId = id;
	}

	public double getTotal() {
		return bikeBikeOrderCost - offerDiscount + shippingCost;
	}

	public void setBikeOrderCost(double orderCost) {
		this.bikeBikeOrderCost = orderCost;
	}

	public int getBikeCount() {
		return bikeList.size();
	}

	public double getOfferDiscount() {
		return offerDiscount;
	}

	public void setOfferDiscount(double offerDiscount) {
		this.offerDiscount = offerDiscount;
	}

	public double getDeliveryCost() {
		return shippingCost;
	}

	public void setDeliveryCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	@Override
	public String toString() {
		return "BikeOrder [id=" + bikeId + ", itemCost=" + bikeBikeOrderCost + ", count=" + bikeCount + ", discount="
				+ offerDiscount
				+ ", shippingCost=" + shippingCost + "]";
	}

	@Override
	public void bikeConfirmed_state() {
		this.state.bikeConfirmed_state();
	}

	@Override
	public void bikeDeliveryStatus_state() {
		this.state.bikeDeliveryStatus_state();
	}

	@Override
	public void bikeDelivered_state() {
		this.state.bikeDelivered_state();
	}
}
