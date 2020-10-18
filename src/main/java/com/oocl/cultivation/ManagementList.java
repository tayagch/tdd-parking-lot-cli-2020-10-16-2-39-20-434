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

    public ManagementList() {

    }

    public List<ParkingBoy> getParkingBoyList() {
        return parkingBoyList;
    }

    public void setParkingBoyList(List<ParkingBoy> parkingBoyList) {
        this.parkingBoyList = parkingBoyList;
    }

    public List<SmartParkingBoy> getSmartParkingBoyList() {
        return smartParkingBoyList;
    }

    public void setSmartParkingBoyList(List<SmartParkingBoy> smartParkingBoyList) {
        this.smartParkingBoyList = smartParkingBoyList;
    }

    public List<SuperSmartParkingBoy> getSuperSmartParkingBoyList() {
        return superSmartParkingBoyList;
    }

    public void setSuperSmartParkingBoyList(List<SuperSmartParkingBoy> superSmartParkingBoyList) {
        this.superSmartParkingBoyList = superSmartParkingBoyList;
    }
}
