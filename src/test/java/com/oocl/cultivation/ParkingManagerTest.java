package com.oocl.cultivation;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingManagerTest {

    List<ParkingLot> parkingLots1;
    List<ParkingLot> parkingLots2;
    List<ParkingLot> parkingLots3;
    ParkingBoy parkingBoy1;
    ParkingBoy parkingBoy2;
    SmartParkingBoy smartParkingBoy1;
    SmartParkingBoy smartParkingBoy2;
    SuperSmartParkingBoy superSmartParkingBoy1;
    SuperSmartParkingBoy superSmartParkingBoy2;

    List<ParkingBoy> parkingBoyList;
    List<SmartParkingBoy> smartParkingBoyList;
    List<SuperSmartParkingBoy> superSmartParkingBoyList;

    @Before
    public void setup(){
        parkingLots1 = Arrays.asList(new ParkingLot(10),new ParkingLot(10));
        parkingLots2 = Arrays.asList(new ParkingLot(10),new ParkingLot(15));
        parkingLots3 = Arrays.asList(new ParkingLot(15),new ParkingLot(10));

        parkingBoy1 = new ParkingBoy(parkingLots1);
        parkingBoy2 = new ParkingBoy(parkingLots1);

        smartParkingBoy1 = new SmartParkingBoy(parkingLots2);
        smartParkingBoy2 = new SmartParkingBoy(parkingLots2);

        superSmartParkingBoy1 = new SuperSmartParkingBoy(parkingLots3);
        superSmartParkingBoy2 = new SuperSmartParkingBoy(parkingLots3);

        parkingBoyList = Arrays.asList(parkingBoy1, parkingBoy2);
        smartParkingBoyList = Arrays.asList(smartParkingBoy1,smartParkingBoy2);
        superSmartParkingBoyList = Arrays.asList(superSmartParkingBoy1,superSmartParkingBoy2);
    }

    @Test
    public void should_return_management_list_when_parkingManager_add_parking_boy_given_parkingManager_add_parking_boy_to_management_list(){
        // Given


        // When
        ParkingManager parkingManger = new ParkingManager(new ManagementList(parkingBoyList, smartParkingBoyList, superSmartParkingBoyList));

        // Then
        assertNotNull(parkingManger.getManagementList());
        assertSame(parkingBoy1,parkingBoyList.get(0));
        assertSame(smartParkingBoy1,smartParkingBoyList.get(0));
        assertSame(superSmartParkingBoy1,superSmartParkingBoyList.get(0));
    }
}
