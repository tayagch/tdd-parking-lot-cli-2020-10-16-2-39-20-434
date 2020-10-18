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
            throw new IndexOutOfBoundsException("Not enough position");
        }

    }

    public Car fetch(ParkingTicket parkingTicket) throws UnrecognizedTicketException {
        Car car = parkingTicketCarMap.get(parkingTicket);
        parkingTicketCarMap.remove(parkingTicket);
        if(car != null){
            return car;
        }else
            throw new UnrecognizedTicketException("Unrecognized Parking Ticket");
    }

    public int getAvailableLots() {
        return lotCapacity - parkingTicketCarMap.size();
    }

    public int getLotCapacity() {
        return lotCapacity;
    }

    public void setLotCapacity(int lotCapacity) {
        this.lotCapacity = lotCapacity;
    }

    public Map<ParkingTicket,Car> getParkingTicketCarMap(){
        return parkingTicketCarMap;
    }
}
