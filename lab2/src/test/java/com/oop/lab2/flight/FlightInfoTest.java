package com.oop.lab2.flight;

import com.oop.lab2.airport.Airport;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class FlightInfoTest {

    @Test
    void testGetSet () {
        FlightInfo flight = new FlightInfo(1L, 2L, 3L, 2L);
        assertEquals(1L, flight.getId());
        assertEquals(2L, flight.getFrom());
        assertEquals(3L, flight.getTo());
        assertEquals(2L, flight.getDeparture());
        assertEquals(2L, flight.getDatetime());
    }

    @Test
    void testToString() {

        FlightInfo flight = new FlightInfo(1L, 2L, 3L, 2L);
        assertEquals(1L, flight.getId());
        assertEquals(2L, flight.getFrom());
        assertEquals(3L, flight.getTo());
        assertEquals(2L, flight.getDeparture());
        assertEquals(flight.toString(), "FlightInfo{from=2, to=3, datetime=2}");
    }

    @Test
    void testEquals() {
        FlightInfo flight = new FlightInfo(1L, 2L, 3L, 2L);
        FlightInfo flight2 = new FlightInfo(1L, 2L, 3L, 2L);
        assertEquals(flight, flight2);
        flight2.setDeparture(10L);
        assertNotEquals(flight, flight2);
    }

    @Test
    void testHashCode() {
        FlightInfo flight = new FlightInfo(1L, 2L, 3L, 2L);
        FlightInfo flight2 = new FlightInfo(3L, 1L, 2L, 0L);
        flight2.setId(1L);
        flight2.setFrom(2L);
        flight2.setTo(3L);
        flight2.setDatetime(2L);
        flight2.setDeparture(2L);
        assertEquals(flight.hashCode(), flight2.hashCode());

    }
}