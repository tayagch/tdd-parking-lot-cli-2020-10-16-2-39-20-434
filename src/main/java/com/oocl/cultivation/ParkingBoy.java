package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {
    Map<ParkingTicket,Car> parkingTicketCarMap = new HashMap<>();

    public ParkingBoy(ParkingLot parkingLot) {

    }

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicketCarMap.put(parkingTicket,car);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkingTicketCarMap.get(parkingTicket);
    }
}
