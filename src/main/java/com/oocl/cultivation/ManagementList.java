package com.oocl.cultivation;

import java.util.List;

public class ManagementList {
    private List<ParkingBoy> parkingBoyList;
    private List<SmartParkingBoy> smartParkingBoyList;
    private List<SuperSmartParkingBoy> superSmartParkingBoyList;

    public ManagementList(List<ParkingBoy> parkingBoyList, List<SmartParkingBoy> smartParkingBoyList, List<SuperSmartParkingBoy> superSmartParkingBoyList) {
        this.parkingBoyList = parkingBoyList;
        this.smartParkingBoyList = smartParkingBoyList;
        this.superSmartParkingBoyList = superSmartParkingBoyList;

    }
}
