package com.oocl.cultivation;

public class ParkingManager {
    private ManagementList managementList;

    public ParkingManager(ManagementList managementList) {
        this.managementList = managementList;
    }

    public ManagementList getManagementList() {
        return managementList;
    }
}
