package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    public void should_return_parkingTicket_when_parkingBoy_park_car_given_parkingBoy_a_car(){
        // Given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));

        // When
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // Then
        assertNotNull(parkingTicket);
    }
    
    @Test
    public void should_return_carFetched_when_fetch_given_parkingTicket(){
        // Given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // When
        Car fetchedCar = parkingBoy.fetch(parkingTicket);

        // Then
        assertSame(car,fetchedCar);
    }
    
    @Test
    public void should_return_two_cars_when_fetch_two_cars_with_ticket_given_parking_boy_park_two_cars(){
        // Given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket1 = parkingBoy.park(car1);
        ParkingTicket parkingTicket2 = parkingBoy.park(car2);

        // When
        Car fetchedCar1 = parkingBoy.fetch(parkingTicket1);
        Car fetchedCar2 = parkingBoy.fetch(parkingTicket2);

        // Then
        assertSame(car1,fetchedCar1);
        assertSame(car2,fetchedCar2);
    }
    
    @Test
    public void should_return_no_car_when_fetch_a_car_given_wrong_ticket(){
        // Given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // When
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(new ParkingTicket()));

        // Then
        assertEquals("Unrecognized Parking Ticket",exception.getMessage());
    }
    
    @Test
    public void should_return_no_car_when_fetch_a_car_given_no_ticket(){
        // Given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));

        // When
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(null));

        // Then
        assertEquals("Please provide your parking ticket",exception.getMessage());
    }
    
    @Test
    public void should_return_no_car_when_fetch_a_car_given_parkingTicket_already_used(){
        // Given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // When
        Car fetchedCar = parkingBoy.fetch(parkingTicket);
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(new ParkingTicket()));

        // Then
        assertEquals("Unrecognized Parking Ticket",exception.getMessage());
    }

    @Test
    public void should_return_park_failed_and_no_ticket_when_park_a_car_given_parking_lot_capacity_is_1_and_parked_a_car(){
        // Given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));

        Car car2 = new Car();
        parkingBoy.park(car2);

        // When
        Car car3 = new Car();
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> parkingBoy.park(car3));

        // Then
        assertEquals("Not enough position",exception.getMessage());
    }
    
    @Test
    public void should_park_to_second_parkingLot_and_return_parking_ticket_when_first_parkingLot_is_full_given_parkingBoy_first_parkingLot_capacity_is_10(){
        // Given
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(0), new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();

        // When
        ParkingTicket parkingTicket = parkingBoy.park(car);
        // Then

        assertNotNull(parkingTicket);
    }

    @Test
    public void should_fetch_correct_car_from_parkingLot_2_when_parkingBoy_park_given_parkingBoy_park_parking_lot_2(){
        // Given
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(0), new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // When
        Car fetchedCar = parkingBoy.fetch(parkingTicket);

        // Then
        assertSame(car,fetchedCar);
    }
}
