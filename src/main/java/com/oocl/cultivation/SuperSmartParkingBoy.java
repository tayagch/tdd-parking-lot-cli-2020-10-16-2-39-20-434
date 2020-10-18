package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperSmartParkingBoy extends ParkingBoy{
    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public ParkingTicket park(Car car) {
        return Optional.ofNullable(getParkingLotList()).map(parkingLots -> {
            return parkingLots.stream().max(Comparator.comparing(ParkingLot::getPositionRate)).get();
        }).orElse(getParkingLot()).park(car);
    }
}
