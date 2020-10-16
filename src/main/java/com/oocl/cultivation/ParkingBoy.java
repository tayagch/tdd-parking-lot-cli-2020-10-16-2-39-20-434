package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {
    Map<ParkingTicket,Car> parkingTicketCarMap = new HashMap<>();

    public ParkingBoy(ParkingLot parkingLot) {

    }

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        if(!parkingTicketCarMap.containsValue(car)){
            parkingTicketCarMap.put(parkingTicket,car);
            return parkingTicket;
        }else{
            return null;
        }

    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car car = parkingTicketCarMap.get(parkingTicket);
        parkingTicketCarMap.remove(parkingTicket);
        return car;
    }
}
