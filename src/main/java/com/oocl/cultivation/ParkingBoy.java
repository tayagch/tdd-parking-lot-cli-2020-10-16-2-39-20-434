package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {


    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {

        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if(parkingTicket == null){
            throw new UnrecognizedTicketException("Please provide your parking ticket");
        }
        return parkingLot.fetch(parkingTicket);
    }
}
