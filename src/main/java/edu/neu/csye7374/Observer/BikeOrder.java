package edu.neu.csye7374.Observer;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.Prototype.BikeShippingType;
import neu.csye7374.src.State_Pattern.OrderStateAPI;

public class BikeOrder implements OrderStateAPI {
		 
		private int bikeId;
		private double bikeOrderCost=0;
		private int bikeCount=0;
		private double offerDiscount=0;
		private double shippingCost;
		private BikeShippingType deliveryType;
		private static int counter=0;
		private List<CheckoutObserverAPI> observers = new ArrayList<>();
		private List<BikeAPI> bikeList = new ArrayList<>();
		
		{
			observers.add(new BikePriceObserver());
			observers.add(new InventoryObserver());
		}
		
		private OrderStateAPI awaitingConfirmationState = new AwaitingConfirmationState(this);
		private OrderStateAPI orderConfirmed = new OrderConfirmed(this);
		private OrderStateAPI orderDispatched = new OrderDispatched(this);
		private OrderStateAPI orderDelivered = new OrderDelivered(this);
		private OrderStateAPI state;
		
		
		
		public BikeOrder() {
			super();
			this.bikeId = ++counter;
			this.deliveryType = BikeShippingType.Pickup;
			this.state = getAwaitingConfirmationState();
		}


		public BikeOrder(double orderCost, int bikeCount, double shippingCost, BikeShippingType deliveryType) {
			super();
			this.bikeId = ++counter;
			this.bikeOrderCost = orderCost;
			this.bikeCount = bikeCount;		
			this.deliveryType = deliveryType;
			
			if(deliveryType==BikeShippingType.Pickup) {
				this.shippingCost = 0;
			}else {
				this.shippingCost = shippingCost;
			}
			this.state = getAwaitingConfirmationState();
		}
		
		
		public void addBike(BikeAPI Bike) {
			bikeList.add(Bike);
			bikeOrderCost+=Bike.getBikePrice();
			bikeCount++;
			observers.forEach(o->o.update(this));
		}
		
		public boolean removeBike(BikeAPI Bike) {
			if(bikeList.remove(Bike)) {
				return true;
			}
			return false;
		}
		
		
		

		public OrderStateAPI getAwaitingConfirmationState() {
			return awaitingConfirmationState;
		}


		public void setAwaitingConfirmationState(OrderStateAPI awaitingConfirmationState) {
			awaitingConfirmationState = awaitingConfirmationState;
		}


		public OrderStateAPI getOrderConfirmed() {
			return orderConfirmed;
		}


		public void setOrderConfirmed(OrderStateAPI orderConfirmed) {
			orderConfirmed = orderConfirmed;
		}


		public OrderStateAPI getOrderDelivered() {
			return orderDelivered;
		}


		public void setOrderDelivered(OrderStateAPI orderDelivered) {
			orderDelivered = orderDelivered;
		}


		public OrderStateAPI getOrderDispatched() {
			return orderDispatched;
		}


		public void setOrderDispatched(OrderStateAPI orderDispatched) {
			orderDispatched = orderDispatched;
		}


		public OrderStateAPI getState() {
			return state;
		}


		public void setState(OrderStateAPI state) {
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
			for(BikeAPI b : BikeList) {
				sb.append(b);
				sb.append("; ");
			}
			return sb.toString();
		}


		public DeliveryType getDeliveryType() {
			return deliveryType;
		}


		public void setDeliveryType(BikeShippingType deliveryType) {
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


		public double getBikeOrderCost() {
			return bikeOrderCost;
		}

		public void attach(CheckoutObserverAPI observer) {
			observers.add(observer);
		}
		
		public void detach(CheckoutObserverAPI observer) {
			observers.remove(observer);
		}
		
		public BikeOrder(int id) {
			this.bikeId=id;
		}

		public int getBikeId() {
			return bikeId;
		}

		public void setBikeId(int id) {
			this.bikeId = id;
		} 

		public double getTotal() {
			return bikeOrderCost - offerDiscount + shippingCost;
		}

		public void setOrderCost(double orderCost) {
			this.bikeOrderCost = orderCost;
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
			return "Order [id=" + bikeId + ", itemCost=" + bikeOrderCost + ", count=" + bikeCount + ", discount=" + offerDiscount
					+ ", shippingCost=" + shippingCost+ "]";
		}


		@Override
		public void state_Awaiting_OrderConfirmation() {
			this.state.state_Awaiting_OrderConfirmation();		
		}


		@Override
		public void state_OrderConfirmed() {
			this.state.state_OrderConfirmed();		
		}


		@Override
		public void state_OrderDispatched() {
			this.state.state_OrderDispatched();
		}


		@Override
		public void state_OrderDelivered() {
			this.state.state_OrderDelivered();
		}	
	}


