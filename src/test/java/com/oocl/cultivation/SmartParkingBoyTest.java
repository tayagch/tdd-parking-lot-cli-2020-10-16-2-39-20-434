package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    public void should_return_parkingTicket_when_smart_parkingBoy_park_car_given_smart_parkingBoy_a_car(){
        // Given
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(10));

        // When
        ParkingTicket parkingTicket = smartParkingBoy.park(car);

        // Then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_carFetched_when_fetch_given_parkingTicket(){
        // Given
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket = smartParkingBoy.park(car);

        // When
        Car fetchedCar = smartParkingBoy.fetch(parkingTicket);

        // Then
        assertSame(car,fetchedCar);
    }

    @Test
    public void should_return_two_cars_when_fetch_two_cars_with_ticket_given_smart_parking_boy_park_two_cars(){
        // Given
        Car car1 = new Car();
        Car car2 = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket1 = smartParkingBoy.park(car1);
        ParkingTicket parkingTicket2 = smartParkingBoy.park(car2);

        // When
        Car fetchedCar1 = smartParkingBoy.fetch(parkingTicket1);
        Car fetchedCar2 = smartParkingBoy.fetch(parkingTicket2);

        // Then
        assertSame(car1,fetchedCar1);
        assertSame(car2,fetchedCar2);
    }

    @Test
    public void should_return_no_car_when_fetch_a_car_given_wrong_ticket(){
        // Given
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket = smartParkingBoy.park(car);

        // When
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> smartParkingBoy.fetch(new ParkingTicket()));

        // Then
        assertEquals("Unrecognized Parking Ticket",exception.getMessage());
    }

    @Test
    public void should_return_no_car_when_fetch_a_car_given_no_ticket(){
        // Given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(10));

        // When
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> smartParkingBoy.fetch(null));

        // Then
        assertEquals("Please provide your parking ticket",exception.getMessage());
    }

    @Test
    public void should_return_no_car_when_fetch_a_car_given_parkingTicket_already_used(){
        // Given
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket = smartParkingBoy.park(car);

        // When
        Car fetchedCar = smartParkingBoy.fetch(parkingTicket);
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> smartParkingBoy.fetch(new ParkingTicket()));

        // Then
        assertEquals("Unrecognized Parking Ticket",exception.getMessage());
    }

    @Test
    public void should_return_park_failed_and_no_ticket_when_park_a_car_given_parking_lot_capacity_is_1_and_parked_a_car(){
        // Given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(1));

        Car car2 = new Car();
        smartParkingBoy.park(car2);

        // When
        Car car3 = new Car();
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> smartParkingBoy.park(car3));

        // Then
        assertEquals("Not enough position",exception.getMessage());
    }
    
    @Test
    public void should_park_on_parking_lot_contains_more_capacity_when_smartParkBoy_park_given_three_parking_lot(){
        // Given
        ParkingLot parkingLot1 = new ParkingLot(9);
        ParkingLot parkingLot2 = new ParkingLot(8);
        ParkingLot parkingLot3 = new ParkingLot(10);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2, parkingLot3);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();

        // When
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // Then
        assertNotNull(parkingTicket);
        assertTrue(parkingLot3.getParkingTicketCarMap().containsKey(parkingTicket));
    }
}
