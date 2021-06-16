package com.oop.lab2.flight;

import static org.junit.jupiter.api.Assertions.*;


import com.oop.lab2.airport.Airport;
import com.oop.lab2.employee.Employee;
import jdk.jshell.execution.LoaderDelegate;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    @Test
    void testGetSet () {
        Airport airport = new Airport(1L, "B", "B city", "B country");
        LocalDateTime now = LocalDateTime.of(2000, Month.APRIL,2, 13, 0);
        Flight flight = new Flight(1L, airport, airport, now);
        assertEquals(1L, flight.getId());
        assertEquals(airport, flight.getFrom());
        assertEquals(airport, flight.getTo());
        assertEquals(now, flight.getDeparture());
    }

    @Test
    void testToString() {

        Airport airport = new Airport(1L, "B", "B city", "B country");
        LocalDateTime now = LocalDateTime.of(2000, Month.APRIL,2, 13, 0);
        Flight flight = new Flight(1L, airport, airport, now);
        assertEquals(1L, flight.getId());
        assertEquals(airport, flight.getFrom());
        assertEquals(airport, flight.getTo());
        assertEquals(now, flight.getDeparture());
        assertEquals(now, flight.getDeparture());
        assertEquals(flight.toString(), "Flight{from=Airport{id=1, name='B', city='B city', country='B country'}, to=Airport{id=1, name='B', city='B city', country='B country'}, dateTime=2000-04-02T13:00}");
    }

    @Test
    void testEquals() {
        Airport airport = new Airport(1L, "B", "B city", "B country");
        LocalDateTime now = LocalDateTime.of(2000, Month.APRIL,2, 13, 0);
        Flight flight = new Flight(airport, airport, now);
        flight.setId(1L);
        Airport airport2 = new Airport(1L, "B", "B city", "B country");
        LocalDateTime now2 = LocalDateTime.of(2000, Month.APRIL,2, 13, 0);
        Flight flight2 = new Flight();
        flight2.setId(1L);
        flight2.setDeparture(now);
        flight2.setTo(airport2);
        flight2.setFrom(airport2);
        assertEquals(flight, flight2);
        flight2.setDeparture(LocalDateTime.now());
        assertNotEquals(flight, flight2);
    }

    @Test
    void testHashCode() {
        Airport airport = new Airport(1L, "B", "B city", "B country");
        LocalDateTime now = LocalDateTime.of(2000, Month.APRIL,2, 13, 0);
        Flight flight = new Flight(1L, airport, airport, now);
        Airport airport2 = new Airport(1L, "B", "B city", "B country");
        LocalDateTime now2 = LocalDateTime.of(2000, Month.APRIL,2, 13, 0);
        Flight flight2 = new Flight(1L, airport, airport, now);
        assertEquals(flight.hashCode(), flight2.hashCode());
        flight2.setDeparture(LocalDateTime.now());
        assertNotEquals(flight.hashCode(), flight2.hashCode());

    }
}