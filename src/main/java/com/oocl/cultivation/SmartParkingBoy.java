package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public ParkingTicket park(Car car) {
        return Optional.ofNullable(getParkingLotList()).map(parkingLots -> {
           return parkingLots.stream().max(Comparator.comparing(ParkingLot::getAvailableLots)).get();
        }).orElse(getParkingLot()).park(car);
    }
}
