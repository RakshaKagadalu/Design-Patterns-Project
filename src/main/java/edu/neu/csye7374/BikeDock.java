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
import edu.neu.csye7374.Decorator.BikeDecorator;
import edu.neu.csye7374.Decorator.GearDecorator;
import edu.neu.csye7374.Decorator.HelmetDecorator;
import edu.neu.csye7374.Decorator.Insurance;
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
    private static final String FILE_NAME = "src/main/java/edu/neu/csye7374/data/NEUBikesData.txt";

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
        System.out.println("\n");

        System.out.println("\t" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("------------ Builder ------- Eager Singleton ------- Factory Patterns used -------");
        BikeBuilder bikeBuilder = new BikeBuilder(1, "Talon", 600, BikeCategory.RoadBikes, "GIANT BIKES");
        BikeAPI bike = BikeFactory.getInstance().getObject(bikeBuilder);
        bikeList.add((Bike) bike);
        System.out.println("");
        System.out.println(bike);
        FileUtil.appendEntryToFile(FILE_NAME, bikeBuilder);
        System.out.println("");
        System.out.println("\t" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));

        System.out.println("\n");
        System.out.println("\t" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Prototype ------------");
        System.out.println("");
        Manufacturer manufact = Manufacturer.getInstance();
        Manufacturer man = manufact.clone();
        man.setManufacturerName("Hercules")
                .setManufacturingYear(2015)
                .setNoOfBikesReleased(200);
        System.out.println(man);
        System.out.println("");
        System.out.println("\t" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("\t" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Adapter Pattern using Bike ------------");
        System.out.println("");
        ManufacturerObjectAdapter manufacturerAdapter = new ManufacturerObjectAdapter(bike, man);

        System.out.println(manufacturerAdapter);
        System.out.println("");
        System.out.println("\t" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("\t" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Facade ----------- Decorator ---------- Observer ------------");
        System.out.println("");
        BikeOrderFacade orderFacade = new BikeOrderFacade(bike);
        BikeOrder order = orderFacade.bikeOrder();
        System.out.println("");
        System.out.println(order);
        System.out.println("");
        order.setBikeDeliveryType(BikeDeliveryType.Delivery);

        bikeBuilder = new BikeBuilder(2, "Fuel EX", 750, BikeCategory.HybridBikes, "TREK BIKES");
        bike = BikeFactory.getInstance().getObject(bikeBuilder);
        BikeDecorator gearBike = new GearDecorator(bike);
        System.out.println(gearBike);
        order.addBike(gearBike);
        System.out.println("");
        System.out.println(order);
        System.out.println("");
        bikeList.add((Bike) bike);
        FileUtil.appendEntryToFile(FILE_NAME, bikeBuilder);

        bikeBuilder = new BikeBuilder(3, "Atroz", 1200, BikeCategory.RoadBikes, "DIAMONDBACK BIKES");
        bike = BikeFactory.getInstance().getObject(bikeBuilder);
        BikeDecorator insuranceBike = new Insurance(bike);
        System.out.println(insuranceBike);
        order.addBike(insuranceBike);
        System.out.println("");
        System.out.println(order);
        System.out.println("");
        bikeList.add((Bike) bike);
        FileUtil.appendEntryToFile(FILE_NAME, bikeBuilder);

        bikeBuilder = new BikeBuilder(4, "Stinson", 699, BikeCategory.CrossBikes, "MARIN BIKES");
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
        System.out.println("");
        System.out.println("\t" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("\t" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Command Pattern ------------");
        System.out.println("");
        Invoker invoker = new Invoker();
        System.out.println("######## Sold Bikes #########");
        invoker.placeBikeOrders(bikeList);
        System.out.println("");
        System.out.println("######## Rented Bikes #########");
        invoker.rentBikeOrders(bikeList);
        System.out.println("");
        System.out.println("\t" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("\t" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Factory ------------ Singleton ---------- EmployeeBuilder ----------");
        System.out.println("");
        BikeDock bikeStr = new BikeDock("NEU");
        EmployeeBuilder emplBuilder = new EmployeeBuilder(7, 27, "John", "Doe", 18.5);
        Employee empl = EmployeeFactory.getInstance().getObject(emplBuilder);
        System.out.println(empl);
        System.out.println("");
        System.out.println("\t" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("\t" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- State ------------");
        System.out.println("");

        System.out.println("Trying to confirm the order after the order is confirmed");
        order.bikeConfirmed_state();
        System.out.println("Trying to deliver the order after the order is confirmed");
        order.bikeDelivered_state();
        System.out.println("Trying to dispatch the order after the order is confirmed");
        order.bikeDeliveryStatus_state();
        System.out.println("Trying to deliver the order after the order is dispatched");
        order.bikeDelivered_state();
        System.out.println("Trying to deliver the order after the order is delivered");
        order.bikeDelivered_state();
        System.out.println("");
        System.out.println("\t" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");

        System.out.println("\t" + ".".repeat(30) + "Pattern Demo Start" + ".".repeat(30));
        System.out.println("");
        System.out.println("----------- Strategy ------------");
        System.out.println("");
        System.out.println("Bike before discount: \n" + bike);
        double price = 0;
        for (OfferStrategy strategy : BikeDock.getAlgorithmMap().keySet()) {
            bikeStr.setUsingStrategy(strategy);
            price = ((Bike) bike).runStrategy();
            System.out.println("Bike price after discount during sale: " + strategy + " Price :" + price);
        }
        System.out.println("");
        System.out.println("\t" + ".".repeat(30) + "Pattern Demo End" + ".".repeat(30));
        System.out.println("\n");
    }

}
