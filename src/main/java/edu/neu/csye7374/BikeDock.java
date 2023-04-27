package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.neu.csye7374.Adapter.Manufacturer;
import edu.neu.csye7374.Adapter.ManufacturerObjectAdapter;
import edu.neu.csye7374.Builder.BikeBuilder;
import edu.neu.csye7374.Builder.EmployeeBuilder;
import edu.neu.csye7374.Command.Invoker;
import edu.neu.csye7374.Facade.BikeDeliveryType;
import edu.neu.csye7374.Facade.BikeOrderFacade;
import edu.neu.csye7374.Factory.BikeFactory;
import edu.neu.csye7374.Factory.BikeFactoryAPI;
import edu.neu.csye7374.Factory.EmployeeFactory;
import edu.neu.csye7374.Observer.BikeOrder;
import edu.neu.csye7374.state_DP.*;
import edu.neu.csye7374.Strategy.*;
import edu.neu.csye7374.fileUtil.FileUtil;

public class BikeDock implements BikeDockStateAPI {

    private String name;
    private List<Bike> itemList = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
    public static OfferStrategy usingStrategy = OfferStrategy.NONE;
    private static final String FILE_NAME = "src/main/java/edu/neu/csye7374/input/team2input.txt";

    private BikeDockStateAPI openState = new DockOpen(this);
    private BikeDockStateAPI closeState = new DockClose(this);
    private BikeDockStateAPI state;

    private static Map<OfferStrategy, OfferStrategyAPI> algorithmMap = new HashMap<>();
    {
        algorithmMap.put(OfferStrategy.StudentOfferStrategy, new StudentOfferStrategy());
        algorithmMap.put(OfferStrategy.ExchangeOfferStrategy, new ExchangeOfferStrategy());
        algorithmMap.put(OfferStrategy.CoupleOfferStrategy, new CoupleOfferStrategy());
        algorithmMap.put(OfferStrategy.NewMemberOfferStrategy, new NewMemberOfferStrategy());
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

    public static OfferStrategy getUsingStrategy() {
        return usingStrategy;
    }

    public static void setUsingStrategy(OfferStrategy usingStrategy) {
        BikeDock.usingStrategy = usingStrategy;
    }

    public static Map<OfferStrategy, OfferStrategyAPI> getAlgorithmMap() {
        return algorithmMap;
    }

    public static void setAlgorithmMap(Map<OfferStrategy, OfferStrategyAPI> algorithmMap) {
        BikeDock.algorithmMap = algorithmMap;
    }

    public BikeDockStateAPI getState() {
        return state;
    }

    public void setState(BikeDockStateAPI state) {
        this.state = state;
    }

    public BikeDockStateAPI getOpenState() {
        return openState;
    }

    public void setOpenState(BikeDockStateAPI openState) {
        this.openState = openState;
    }

    public BikeDockStateAPI getCloseState() {
        return closeState;
    }

    public void setCloseState(BikeDockStateAPI closeState) {
        this.closeState = closeState;
    }

    @Override
    public void dock_Open() {
        // TODO Auto-generated method stub
        this.state.dock_Open();

    }

    @Override
    public void dock_Close() {
        // TODO Auto-generated method stub
        this.state.dock_Close();
    }

    public static void demo() {

        FileUtil.getFileData(FILE_NAME);

        List<Bike> bikeList = new ArrayList<>();
        // Builder Pattern and getting object of Builder using Factory and Singleton
        // Pattern
        System.out.println("***************************************************************************************");
        System.out.println(
                "Demonstration of Builder pattern. Delegating the responsibilty of creating Bikes objects to Bike Builder which implements build method and builds bike object for us");
        System.out.println("Using Factory and singleton pattern to get only single instance of Bike Builder object");
        BikeBuilder bikeBuilder = new BikeBuilder(1, "M100", 250, BikeCategory.RoadBikes, "Schnell");
        BikeAPI bike = BikeFactory.getInstance().getObject(bikeBuilder);
        bikeList.add((Bike) bike);
        System.out.println(bike);
        FileUtil.appendEntryToFile(FILE_NAME, bikeBuilder);

        // Prototype Pattern to clone the object of author
        System.out.println("***************************************************************************************");
        System.out.println("Demonstration of prototype pattern to clone the object of Manufacturer");
        Manufacturer author = Manufacturer.getInstance().clone();
        author.setManufacturerName("Schnell")
                .setManufacturingYear(2021)
                .setNoOfBikesReleased(250);

        // Adapter Pattern to adapt adapt author legacy code with Bike Interface
        ManufacturerObjectAdapter manufacturerAdapter = new ManufacturerObjectAdapter(bike, author);

        System.out.println(bike);
        System.out.println("***************************************************************************************");
        System.out.println(
                "Demonstration of Adapter pattern to adapt manufacturer legacy class with Bike Interface and priting their object");

        System.out.println(manufacturerAdapter);
        System.out.println("***************************************************************************************");

        // Demonstration of facade pattern and decorator pattern to decorate the bike
        // object
        System.out.println(
                "Demonstration of Facade pattern and adding Decorator pattern to decorate bikes and adding it to our order list");
        System.out.println(
                "Demonstration of Observer pattern to notify the shipping cost and discount observer of changes as the number of our orders added into order list");

        BikeOrderFacade orderFacade = new BikeOrderFacade(bike);
        BikeOrder order = orderFacade.bikeOrder();

        System.out.println(order);
        order.setBikeDeliveryType(BikeDeliveryType.Delivery);

        bikeBuilder = new BikeBuilder(2, "HighLand 26\"", 149.99, BikeCategory.HybridBikes, "Huffy");
        bike = BikeFactory.getInstance().getObject(bikeBuilder);
        order.addBike(bike);
        System.out.println(order);
        bikeList.add((Bike) bike);
        FileUtil.appendEntryToFile(FILE_NAME, bikeBuilder);

        bikeBuilder = new BikeBuilder(3, "BeauMont", 300, BikeCategory.RoadBikes, "Retrospec");
        bike = BikeFactory.getInstance().getObject(bikeBuilder);
        order.addBike(bike);
        System.out.println(order);
        bikeList.add((Bike) bike);
        FileUtil.appendEntryToFile(FILE_NAME, bikeBuilder);

        bikeBuilder = new BikeBuilder(4, "Triban", 210, BikeCategory.CrossBikes, "Retrospec");
        bike = BikeFactory.getInstance().getObject(bikeBuilder);
        order.addBike(bike);
        System.out.println(order);
        bikeList.add((Bike) bike);
        FileUtil.appendEntryToFile(FILE_NAME, bikeBuilder);

        bikeBuilder = new BikeBuilder(5, "Rockrider", 150, BikeCategory.HybridBikes, "Btwin");
        bike = BikeFactory.getInstance().getObject(bikeBuilder);
        order.addBike(bike);
        System.out.println(order);
        bikeList.add((Bike) bike);

        bikeBuilder = new BikeBuilder(6, "RMX", 350, BikeCategory.TouringBikes, "Royce Union");
        bike = BikeFactory.getInstance().getObject(bikeBuilder);
        order.addBike(bike);
        System.out.println(order);
        bikeList.add((Bike) bike);
        System.out.println("***************************************************************************************");

        // Command Pattern
        System.out.println("Demonstration of Command pattern to send the request for all bikes orders and print them");

        Invoker invoker = new Invoker();
        invoker.placeBikeOrders(bikeList);
        invoker.rentBikeOrders(bikeList);
        System.out.println("***************************************************************************************");

        BikeDock bikeStr = new BikeDock("Northeastern");
        EmployeeBuilder emplBuilder = new EmployeeBuilder(7, 27, "John", "Doe", 18.5);
        Employee empl = EmployeeFactory.getInstance().getObject(emplBuilder);
        System.out
                .println("Using Factory and singleton pattern to get only single instance of Employee Builder object");
        System.out.println(empl);
        System.out.println("***************************************************************************************");

        // State Pattern
        System.out.println(
                "Demonstration of state pattern completed life cycle of order transitioning from ordered to delived state");

        order.bikeConfirmed_state();
        order.bikeDelivered_state();
        order.bikeDeliveryStatus_state();
        order.bikeDelivered_state();
        order.bikeDelivered_state();
        System.out.println("***************************************************************************************");
        // Strategy Pattern
        System.out.println(
                "Demonstration of strategy pattern to show different discounts applied to original price and final price after student and employee discounts ");
        System.out.println("Bike before discount: \n" + bike);
        double price = 0;
        for (OfferStrategy strategy : BikeDock.getAlgorithmMap().keySet()) {
            bikeStr.setUsingStrategy(strategy);
            price = ((Bike) bike).runStrategy();
            System.out.println("Bike price after discount during sale: " + strategy + price);
        }
    }

}
