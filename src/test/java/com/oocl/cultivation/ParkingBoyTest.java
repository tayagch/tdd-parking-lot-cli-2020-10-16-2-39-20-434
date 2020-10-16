package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class ParkingBoyTest {
    @Test
    public void should_return_parkingTicket_when_parkingBoy_park_car_given_parkingBoy_a_car(){
        // Given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        // When
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // Then
        assertNotNull(parkingTicket);
    }
    
    @Test
    public void should_return_carFetched_when_fetch_given_parkingTicket(){
        // Given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // When
        Car fetchedCar = parkingBoy.fetch(parkingTicket);

        // Then
        assertSame(car,fetchedCar);
    }
}
