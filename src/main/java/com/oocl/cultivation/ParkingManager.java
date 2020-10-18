package com.oocl.cultivation;

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

    public Car fetch(ParkingBoy parkingBoy, ParkingTicket parkingTicket) {
        if(parkingBoy.getParkingLot().getParkingTicketCarMap().containsKey(parkingTicket)){
            return parkingBoy.fetch(parkingTicket);
        }
        else{
            throw new UnrecognizedTicketException("Wrong Parking Boy");
        }
    }
}
