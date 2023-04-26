package edu.neu.csye7374.state_DP;

import edu.neu.csye7374.BikeDock;

public class DockOpen implements BikeDockStateAPI {
    private static BikeDock bikedock;

    public DockOpen(BikeDock dock) {
        super();
        DockOpen.bikedock = dock;
    }

    @Override
    public void dock_Open() {
        // TODO Auto-generated method stub
        System.out.println("Error ... Already in Open State");

    }

    @Override
    public void dock_Close() {
        // TODO Auto-generated method stub
        bikedock.setState(bikedock.getCloseState());
        System.out.println("Currently in Close State");
    }

}
