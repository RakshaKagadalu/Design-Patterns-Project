package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.neu.csye7374.Adapter_Pattern.Manufacturer;
import edu.neu.csye7374.Adapter_Pattern.ManufacturerObjectAdapter;
import edu.neu.csye7374.Builder.BikeBuilder;
import edu.neu.csye7374.Builder.EmployeeBuilder;
import edu.neu.csye7374.Command_Pattern.Invoker;
import edu.neu.csye7374.Facade.DeliveryType;
import edu.neu.csye7374.Facade.OrderFacade;
import edu.neu.csye7374.Factory_Pattern.BikeFactory;
import edu.neu.csye7374.Factory_Pattern.EmployeeFactory;
import edu.neu.csye7374.ObserverPattern.Order;
import edu.neu.csye7374.State_Pattern.*;
import edu.neu.csye7374.Strategy_Pattern.*;
import edu.neu.csye7374.fileUtil.FileUtil;

public class BikeDock implements BikeDockAPI {

    private String name;
    private List<Bike> itemList = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
    public static DiscountStrategy usingStrategy = DiscountStrategy.NONE;
    private static final String FILE_NAME = "edu/neu/csye7374/input/team2input.txt";

    private BikeStoreStateAPI openState = new OpenState(this);
    private BikeStoreStateAPI stockState = new StockState(this);
    private BikeStoreStateAPI closeState = new CloseState(this);
    private BikeStoreStateAPI state;

    private static Map<DiscountStrategy, DiscountStrategyAPI> algorithmMap = new HashMap<>();
    {
        // algorithmMap.put(DiscountStrategy.NONE, null);
        algorithmMap.put(DiscountStrategy.StudentDiscount, new StudentDiscount());
        algorithmMap.put(DiscountStrategy.EmployeeDiscount, new EmployeeDiscount());
    }

    public BikeDock(String name) {
        super();
        this.name = name;
        this.state = getOpenState();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bike> getItemList() {
        return itemList;
    }

    public void setItemList(List<Bike> itemList) {
        this.itemList = itemList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public static DiscountStrategy getUsingStrategy() {
        return usingStrategy;
    }

    public static void setUsingStrategy(DiscountStrategy usingStrategy) {
        BikeStore.usingStrategy = usingStrategy;
    }

    public static Map<DiscountStrategy, DiscountStrategyAPI> getAlgorithmMap() {
        return algorithmMap;
    }

    public static void setAlgorithmMap(Map<DiscountStrategy, DiscountStrategyAPI> algorithmMap) {
        BikeStore.algorithmMap = algorithmMap;
    }

    public BikeStoreStateAPI getState() {
        return state;
    }

    public void setState(BikeStoreStateAPI state) {
        this.state = state;
    }

    public BikeStoreStateAPI getOpenState() {
        return openState;
    }

    public void setOpenState(BikeStoreStateAPI openState) {
        this.openState = openState;
    }

    public BikeStoreStateAPI getStockState() {
        return stockState;
    }

    public void setStockState(BikeStoreStateAPI stockState) {
        this.stockState = stockState;
    }

    public BikeStoreStateAPI getCloseState() {
        return closeState;
    }

    public void setCloseState(BikeStoreStateAPI closeState) {
        this.closeState = closeState;
    }

    @Override
    public void state_Open() {
        // TODO Auto-generated method stub
        this.state.state_Open();

    }

    @Override
    public void state_Close() {
        // TODO Auto-generated method stub
        this.state.state_Close();
    }

    @Override
    public void state_Stock() {
        // TODO Auto-generated method stub
        this.state.state_Stock();
    }

    public static void demo() {

        FileUtil.getFileData(FILE_NAME);

        List<Bike> bikeList = new ArrayList<>();

        // Builder Pattern and getting object of Builder using Factory and Singleton
        // Pattern
        System.out.println("***************************************************************************************");
        System.out.println(
                "Demonstrating of Builder pattern. Delegating the responsibilty of creating Bikes objects to Bike Builder which implements build method and builds bike object for us");
        System.out.println("Using Factory and singleton pattern to get only single instance of Bike Builder object");
        BikeBuilder bikeBuilder = new BikeBuilder(1, "Harry Potter", 10, BikeCategory.Fiction, "JK Rowling");
        BikeAPI bike = BikeFactoryAPI.getInstance().getObject(bikeBuilder);
        bikeList.add((Bike) bike);
        System.out.println(bike);
        FileUtil.appendEntryToFile(FILE_NAME, bikeBuilder);

        // Prototype Pattern to clone the object of author
        System.out.println("***************************************************************************************");
        System.out.println("Demonstrating of prototype pattern to clone the object of Manufacturer");
        Manufacturer author = Manufacturer.getInstance().clone();
        author.setManufacturerName("JK Rowling")
                .setAge(52)
                .setNoOfBikesPublished(10);

        // Adapter Pattern to adapt adapt author legacy code with Bike Interface
        ManufacturerObjectAdapter authorAdapter = new ManufacturerObjectAdapter(bike, author);

        System.out.println(bike);
        System.out.println("***************************************************************************************");
        System.out.println(
                "Demonstrating of Adapter pattern to adapt author legacy class with Bike Interface and priting their object");

        System.out.println(authorAdapter);
        System.out.println("***************************************************************************************");

        // Demonstration of facade pattern and decorator pattern to decorate the bike
        // object
        System.out.println(
                "Demonstration of Facade pattern and adding Decorator pattern to decorate bikes and adding it to our order list");
        System.out.println(
                "Demonstration of Observer pattern to notify the shipping cost and discount observer of changes as the number of our orders added into order list");

        OrderFacade orderFacade = new OrderFacade(bike);
        Order order = orderFacade.order();

        System.out.println(order);
        order.setDeliveryType(DeliveryType.Delivery);

        bikeBuilder = new BikeBuilder(2, "Yogi Autobiography", 100, BikeCategory.Documentary, "Swami Dayananad");
        bike = BikeFactoryAPI.getInstance().getObject(bikeBuilder);
        order.addBike(bike);
        System.out.println(order);
        bikeList.add((Bike) bike);
        FileUtil.appendEntryToFile(FILE_NAME, bikeBuilder);

        bikeBuilder = new BikeBuilder(3, "Alice in Wonderland", 150, BikeCategory.Fiction, "Scott Ross");
        bike = BikeFactoryAPI.getInstance().getObject(bikeBuilder);
        order.addBike(bike);
        System.out.println(order);
        bikeList.add((Bike) bike);
        FileUtil.appendEntryToFile(FILE_NAME, bikeBuilder);

        bikeBuilder = new BikeBuilder(4, "Last Bout", 101, BikeCategory.Documentary, "Mc Gregor");
        bike = BikeFactoryAPI.getInstance().getObject(bikeBuilder);
        order.addBike(bike);
        System.out.println(order);
        bikeList.add((Bike) bike);
        FileUtil.appendEntryToFile(FILE_NAME, bikeBuilder);

        bikeBuilder = new BikeBuilder(5, "Teresstial Lives", 200, BikeCategory.Scifi, "Phil Hughes");
        bike = BikeFactoryAPI.getInstance().getObject(bikeBuilder);
        order.addBike(bike);
        System.out.println(order);
        bikeList.add((Bike) bike);

        bikeBuilder = new BikeBuilder(6, "Playing my way", 310, BikeCategory.Documentary, "Sachin Tendulkar");
        bike = BikeFactoryAPI.getInstance().getObject(bikeBuilder);
        order.addBike(bike);
        System.out.println(order);
        bikeList.add((Bike) bike);
        System.out.println("***************************************************************************************");

        // Command Pattern
        System.out.println("Demonstration of Command pattern to send the request for all bikes orders and print them");

        Invoker invoker = new Invoker();
        invoker.placeOrders(bikeList);
        invoker.rentOrders(bikeList);
        System.out.println("***************************************************************************************");

        BikeStore bikeStr = new BikeStore("Kindle");
        EmployeeBuilder emplBuilder = new EmployeeBuilder(7, 27, "Daniel", "Peters", 18.5);
        Employee empl = EmployeeFactory.getInstance().getObject(emplBuilder);
        System.out
                .println("Using Factory and singleton pattern to get only single instance of Employee Builder object");
        System.out.println(empl);
        System.out.println("***************************************************************************************");

        // State Pattern
        System.out.println(
                "Demonstration of state pattern completed life cycle of order transitioning from ordered to delived state");

        order.state_Awaiting_OrderConfirmation();
        order.state_OrderConfirmed();
        order.state_OrderDelivered();
        order.state_OrderDispatched();
        order.state_OrderDelivered();
        order.state_OrderDelivered();
        System.out.println("***************************************************************************************");
        // Strategy Pattern
        System.out.println(
                "Demonstration of strategy pattern to show differene discounts applied to original price and final price after student and employee discounts ");
        System.out.println("Bike before discount: \n" + bike);
        double price = 0;
        for (DiscountStrategy strategy : BikeStore.getAlgorithmMap().keySet()) {
            bikeStr.setUsingStrategy(strategy);
            price = ((Bike) bike).runStrategy();
            System.out.println("Bike price after discount during sale: " + strategy + price);
        }
    }

}
