package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<ParkingTicket,Car> parkingTicketCarMap = new HashMap<>();
    private int lotCapacity;

    public ParkingLot(int lotCapacity) {
        this.lotCapacity = lotCapacity;
    }

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        if(!parkingTicketCarMap.containsValue(car)  && parkingTicketCarMap.size() != getLotCapacity()){
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

    public int getLotCapacity() {
        return lotCapacity;
    }

    public void setLotCapacity(int lotCapacity) {
        this.lotCapacity = lotCapacity;
    }
}
