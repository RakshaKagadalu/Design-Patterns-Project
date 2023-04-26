package edu.neu.csye7374.state_DP;

import edu.neu.csye7374.BikeDock;

public class DockClose implements BikeDockStateAPI {

    private static BikeDock bikedock;

    public DockClose(BikeDock dock) {
        super();
        DockClose.bikedock = dock;
    }

    @Override
    public void dock_Open() {
        // TODO Auto-generated method stub
        bikedock.setState(bikedock.getCloseState());
        System.out.println("Transition from Close State to Open State");

    }

    @Override
    public void dock_Close() {
        // TODO Auto-generated method stub
        System.out.println("Error ... Already in Close State");
    }
}
