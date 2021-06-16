package com.oop.lab2.FlightEmployee;

import com.oop.lab2.flight.FlightInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFlightTest {

    @Test
    void testGetSet () {
        EmployeeFlight flight = new EmployeeFlight(1L, 2L);
        assertEquals(2L, flight.getFlightId());
        assertEquals(1L, flight.getEmployeeId());
    }

    @Test
    void testToString() {

        EmployeeFlight flight = new EmployeeFlight();
        flight.setFlightId(1L);
        flight.setEmployeeId(2L);
        assertEquals(1L, flight.getFlightId());
        assertEquals(2L, flight.getEmployeeId());
        assertEquals(flight.toString(), "EmployeeFlight{employeeId=2, flightId=1}");
    }

    @Test
    void testEquals() {
        EmployeeFlight flight = new EmployeeFlight(1L, 2L);
        EmployeeFlight flight2 = new EmployeeFlight(1L, 2L);
        assertEquals(flight, flight2);
        flight2.setFlightId(10L);
        assertNotEquals(flight, flight2);
    }

    @Test
    void testHashCode() {
        EmployeeFlight flight = new EmployeeFlight(1L, 2L);
        EmployeeFlight flight2 = new EmployeeFlight(1L, 2L);
        assertEquals(flight.hashCode(), flight2.hashCode());
        flight2.setFlightId(10L);
        assertNotEquals(flight.hashCode(), flight2.hashCode());

    }
}