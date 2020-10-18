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

    @Test
    public void should_return_correct_car_when_parkingmanager_specify_parkingboy_fetch_given_parkingticket(){
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
        ParkingTicket parkingTicket = parkingManager.park(parkingBoy1,car);

        // When
        Car fetchedCar = parkingManager.fetch(parkingBoy1,parkingTicket);

        // Then
        assertSame(car,fetchedCar);
    }
    
    @Test
    public void should_return_null_when_parkingmanager_specify_parkingboy_fetch_given_wrong_parkingboy_to_fetch(){
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
        ParkingTicket parkingTicket = parkingManager.park(parkingBoy1,car);

        // When
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingManager.fetch(parkingBoy2,parkingTicket));

        // Then
        assertEquals("Wrong Parking Boy",exception.getMessage());
    }

    @Test
    public void should_return_parking_ticket_when_parkingmanager_specify_smartparkingboy_park_given_managementlist_and_car(){
        // Given
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ParkingLot parkingLot3 = new ParkingLot(10);
        List<ParkingLot> parkingLots1 = Arrays.asList(parkingLot1, parkingLot2);
        SmartParkingBoy smartParkingBoy1 = new SmartParkingBoy(parkingLots1);
        SmartParkingBoy smartParkingBoy2 = new SmartParkingBoy(parkingLot3);
        List<ParkingBoy> parkingBoys = Arrays.asList(smartParkingBoy1, smartParkingBoy2);
        ManagementList managementList = new ManagementList();
        ParkingManager parkingManager = new ParkingManager(managementList);
        parkingManager.getManagementList().setParkingBoyList(parkingBoys);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        // When
        ParkingTicket parkingTicket1 = parkingManager.park(smartParkingBoy1,car1);
        ParkingTicket parkingTicket2 = parkingManager.park(smartParkingBoy1,car2);
        ParkingTicket parkingTicket3 = parkingManager.park(smartParkingBoy2,car3);

        // Then
        assertNotNull(parkingTicket1);
        assertNotNull(parkingTicket2);
        assertNotNull(parkingTicket3);
        assertTrue(parkingLot3.getParkingTicketCarMap().containsKey(parkingTicket3));
    }
    
    @Test
    public void should_return_correct_car_when_parkingmanager_specify_smartparking_boy_fetch_given_correct_parking_ticket(){
        // Given
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ParkingLot parkingLot3 = new ParkingLot(10);
        List<ParkingLot> parkingLots1 = Arrays.asList(parkingLot1, parkingLot2);
        SmartParkingBoy smartParkingBoy1 = new SmartParkingBoy(parkingLots1);
        SmartParkingBoy smartParkingBoy2 = new SmartParkingBoy(parkingLot3);
        List<ParkingBoy> parkingBoys = Arrays.asList(smartParkingBoy1, smartParkingBoy2);
        ManagementList managementList = new ManagementList();
        ParkingManager parkingManager = new ParkingManager(managementList);
        parkingManager.getManagementList().setParkingBoyList(parkingBoys);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        ParkingTicket parkingTicket1 = parkingManager.park(smartParkingBoy1,car1);
        ParkingTicket parkingTicket2 = parkingManager.park(smartParkingBoy1,car2);
        ParkingTicket parkingTicket3 = parkingManager.park(smartParkingBoy2,car3);

        // When
        Car fetchedCar1 = parkingManager.fetch(smartParkingBoy1,parkingTicket1);
        Car fetchedCar2 = parkingManager.fetch(smartParkingBoy1,parkingTicket2);
        Car fetchedCar3 = parkingManager.fetch(smartParkingBoy2,parkingTicket3);

        // Then
        assertSame(car1,fetchedCar1);
        assertSame(car2,fetchedCar2);
        assertSame(car3,fetchedCar3);
    }
}
