package com.oocl.cultivation;

import java.util.Optional;

public class ParkingManager {
    private ManagementList managementList;

    public ParkingManager(ManagementList managementList) {
        this.managementList = managementList;
    }

    public ManagementList getManagementList() {
        return managementList;
    }

    public ParkingTicket park(ParkingBoy parkingBoy, Car car) {
        return parkingBoy.park(car);
    }

    public ParkingTicket park(SmartParkingBoy parkingBoy, Car car) {
        return parkingBoy.park(car);
    }

    public Car fetch(ParkingBoy parkingBoy, ParkingTicket parkingTicket) {
        return parkingBoy.fetch(parkingTicket);
    }
}
