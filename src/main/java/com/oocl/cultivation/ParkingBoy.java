package com.oocl.cultivation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public ParkingTicket park(Car car) {
        return Optional.ofNullable(parkingLotList).map(lots -> {
            for (ParkingLot lot:lots) {
                if(lot.getLotCapacity() > 0){
                    return lot;
                }
            }
            throw new IndexOutOfBoundsException("Not enough position");
        }).orElse(parkingLot).park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if(parkingTicket == null){
            throw new UnrecognizedTicketException("Please provide your parking ticket");
        }

        return Optional.ofNullable(parkingLotList).map(lots -> {
            for (ParkingLot lot:lots) {
                if (lot.getParkingTicketCarMap().containsKey(parkingTicket)) {
                    return lot;
                }
            }
            throw new UnrecognizedTicketException("Unrecognized Parking Ticket");
        }).orElse(parkingLot).fetch(parkingTicket);
//        return parkingLot.fetch(parkingTicket);
    }
}
