package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot highestCapacityLot = getParkingLotList().stream().max(Comparator.comparing(ParkingLot::getLotCapacity)).orElse(getParkingLot());
        return highestCapacityLot.park(car);
    }
}
