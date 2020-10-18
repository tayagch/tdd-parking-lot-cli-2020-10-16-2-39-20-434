package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {
    @Test
    public void should_return_parkingTicket_when_smart_parkingBoy_park_car_given_smart_parkingBoy_a_car(){
        // Given
        Car car = new Car();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot(10));

        // When
        ParkingTicket parkingTicket = superSmartParkingBoy.park(car);

        // Then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_carFetched_when_fetch_given_parkingTicket(){
        // Given
        Car car = new Car();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket = superSmartParkingBoy.park(car);

        // When
        Car fetchedCar = superSmartParkingBoy.fetch(parkingTicket);

        // Then
        assertSame(car,fetchedCar);
    }

    @Test
    public void should_return_two_cars_when_fetch_two_cars_with_ticket_given_smart_parking_boy_park_two_cars(){
        // Given
        Car car1 = new Car();
        Car car2 = new Car();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket1 = superSmartParkingBoy.park(car1);
        ParkingTicket parkingTicket2 = superSmartParkingBoy.park(car2);

        // When
        Car fetchedCar1 = superSmartParkingBoy.fetch(parkingTicket1);
        Car fetchedCar2 = superSmartParkingBoy.fetch(parkingTicket2);

        // Then
        assertSame(car1,fetchedCar1);
        assertSame(car2,fetchedCar2);
    }

    @Test
    public void should_return_no_car_when_fetch_a_car_given_wrong_ticket(){
        // Given
        Car car = new Car();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket = superSmartParkingBoy.park(car);

        // When
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> superSmartParkingBoy.fetch(new ParkingTicket()));

        // Then
        assertEquals("Unrecognized Parking Ticket",exception.getMessage());
    }

    @Test
    public void should_return_no_car_when_fetch_a_car_given_no_ticket(){
        // Given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot(10));

        // When
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> superSmartParkingBoy.fetch(null));

        // Then
        assertEquals("Please provide your parking ticket",exception.getMessage());
    }

    @Test
    public void should_return_no_car_when_fetch_a_car_given_parkingTicket_already_used(){
        // Given
        Car car = new Car();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket = superSmartParkingBoy.park(car);

        // When
        Car fetchedCar = superSmartParkingBoy.fetch(parkingTicket);
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> superSmartParkingBoy.fetch(new ParkingTicket()));

        // Then
        assertEquals("Unrecognized Parking Ticket",exception.getMessage());
    }

    @Test
    public void should_return_park_failed_and_no_ticket_when_park_a_car_given_parking_lot_capacity_is_1_and_parked_a_car(){
        // Given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot(1));

        Car car2 = new Car();
        superSmartParkingBoy.park(car2);

        // When
        Car car3 = new Car();
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> superSmartParkingBoy.park(car3));

        // Then
        assertEquals("Not enough position",exception.getMessage());
    }

    @Test
    public void should_return_parkingTicket_for_parking_lot_with_larger_available_position_rate_when_superSmartParkingBoy_park_given_parking_lot_with_15_capacity_and_20_capacity(){
        // Given
        ParkingLot parkingLot1 = new ParkingLot(15);
        ParkingLot parkingLot2 = new ParkingLot(10);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        // When
        ParkingTicket parkingTicket1 = superSmartParkingBoy.park(car1);
        ParkingTicket parkingTicket2 = superSmartParkingBoy.park(car2);
        ParkingTicket parkingTicket3 = superSmartParkingBoy.park(car3);

        // Then

        assertNotNull(parkingTicket3);
        assertTrue(parkingLot2.getParkingTicketCarMap().containsKey(parkingTicket2));
        assertTrue(parkingLot1.getParkingTicketCarMap().containsKey(parkingTicket3));
    }
}
