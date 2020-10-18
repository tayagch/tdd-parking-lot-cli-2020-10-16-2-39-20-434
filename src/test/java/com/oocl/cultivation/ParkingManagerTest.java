package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingManagerTest {

    @Test
    public void should_return_management_list_when_parkingManager_add_parking_boy_given_parkingboy_list(){
        // Given
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ParkingBoy parkingBoy1 = new ParkingBoy(parkingLot1);
        ParkingBoy parkingBoy2 = new ParkingBoy(parkingLot2);
        List<ParkingBoy> parkingBoys = Arrays.asList(parkingBoy1, parkingBoy2);

        // When
        ManagementList managementList = new ManagementList();
        ParkingManager parkingManager = new ParkingManager(managementList);
        parkingManager.getManagementList().setParkingBoyList(parkingBoys);

        // Then
        assertSame(managementList.getParkingBoyList(),parkingManager.getManagementList().getParkingBoyList());
    }

    @Test
    public void should_return_parking_ticket_when_parkingmanager_specify_parkingboy_park_given_managementlist_and_car(){
        // Given
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ParkingBoy parkingBoy1 = new ParkingBoy(parkingLot1);
        ParkingBoy parkingBoy2 = new ParkingBoy(parkingLot2);
        List<ParkingBoy> parkingBoys = Arrays.asList(parkingBoy1, parkingBoy2);
        ManagementList managementList = new ManagementList();
        ParkingManager parkingManager = new ParkingManager(managementList);
        parkingManager.getManagementList().setParkingBoyList(parkingBoys);
        Car car = new Car();
        // When
        ParkingTicket parkingTicket = parkingManager.park(parkingBoy1,car);

        // Then
        assertNotNull(parkingTicket);
    }
}
