package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingManagerTest {
    @Test
    public void should_return_management_list_when_parkingManager_add_parking_boy_given_parkingManager_add_parking_boy_to_management_list(){
        // Given
        List<ParkingLot> parkingLots1 = Arrays.asList(new ParkingLot(10),new ParkingLot(10));
        List<ParkingLot> parkingLots2 = Arrays.asList(new ParkingLot(10),new ParkingLot(10));
        List<ParkingLot> parkingLots3 = Arrays.asList(new ParkingLot(10),new ParkingLot(10));
        ParkingBoy parkingBoy1 = new ParkingBoy(parkingLots1);
        ParkingBoy parkingBoy2 = new ParkingBoy(parkingLots1);
        SmartParkingBoy smartParkingBoy1 = new SmartParkingBoy(parkingLots2);
        SmartParkingBoy smartParkingBoy2 = new SmartParkingBoy(parkingLots2);
        SuperSmartParkingBoy superSmartParkingBoy1 = new SuperSmartParkingBoy(parkingLots3);
        SuperSmartParkingBoy superSmartParkingBoy2 = new SuperSmartParkingBoy(parkingLots3);

        List<ParkingBoy> parkingBoyList = Arrays.asList(parkingBoy1, parkingBoy2);
        List<SmartParkingBoy> smartParkingBoyList = Arrays.asList(smartParkingBoy1,smartParkingBoy2);
        List<SuperSmartParkingBoy> superSmartParkingBoyList = Arrays.asList(superSmartParkingBoy1,superSmartParkingBoy2);

        // When
        ParkingManager parkingManger = new ParkingManager(new ManagementList(parkingBoyList, smartParkingBoyList, superSmartParkingBoyList));

        // Then
        assertNotNull(parkingManger.getManagementList());
        assertSame(parkingBoy1,parkingBoyList.get(0));
        assertSame(smartParkingBoy1,smartParkingBoyList.get(0));
        assertSame(superSmartParkingBoy1,superSmartParkingBoyList.get(0));
    }
}
