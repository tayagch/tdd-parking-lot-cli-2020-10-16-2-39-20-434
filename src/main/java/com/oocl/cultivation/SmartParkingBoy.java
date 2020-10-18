package com.oocl.cultivation;

import java.util.List;
import java.util.Optional;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    public ParkingTicket park(Car car) {
        return Optional.ofNullable(getParkingLotList()).map(lots -> {
            for (ParkingLot lot:lots) {
                if(lot.getLotCapacity() > 0){
                    return lot;
                }
            }
            throw new IndexOutOfBoundsException("Not enough position");
        }).orElse(getParkingLot()).park(car);
    }
}
