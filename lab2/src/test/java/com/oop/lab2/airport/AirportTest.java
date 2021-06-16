package com.oop.lab2.airport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    @Test
    void testGetSet () {
        Airport airport = new Airport(1L, "B", "B city", "B country");
        assertEquals(1L, airport.getId());
        assertEquals("B", airport.getName());
        assertEquals("B city", airport.getCity());
        assertEquals("B country", airport.getCountry());

        airport.setId(2L);
        airport.setName("A");
        airport.setCity("A city");
        airport.setCountry("A country");

        assertEquals(2L, airport.getId());
        assertEquals("A", airport.getName());
        assertEquals("A city", airport.getCity());
        assertEquals("A country", airport.getCountry());
    }

    @Test
    void testToString() {

        Airport airport = new Airport();
        airport.setId(1L);
        airport.setName("B");
        airport.setCity("B city");
        airport.setCountry("B country");
        assertEquals(1L, airport.getId());
        assertEquals("B", airport.getName());
        assertEquals("B city", airport.getCity());
        assertEquals("B country", airport.getCountry());
        assertEquals(airport.toString(), "Airport{id=1, name='B', city='B city', country='B country'}");
    }

    @Test
    void testEquals() {
        Airport airport1 = new Airport(1L, "B", "B city", "B country");
        assertEquals(1L, airport1.getId());
        assertEquals("B", airport1.getName());
        assertEquals("B city", airport1.getCity());
        assertEquals("B country", airport1.getCountry());
        assertEquals(airport1.toString(), "Airport{id=1, name='B', city='B city', country='B country'}");
        Airport airport2 = new Airport(1L, "B", "B city", "B country");
        assertEquals(1L, airport2.getId());
        assertEquals("B", airport2.getName());
        assertEquals("B city", airport2.getCity());
        assertEquals("B country", airport2.getCountry());
        assertEquals(airport2.toString(), "Airport{id=1, name='B', city='B city', country='B country'}");
        assertEquals(airport1, airport2);
        airport2.setCity("A");
        assertNotEquals(airport1, airport2);
    }

    @Test
    void testHashCode() {
        Airport airport1 = new Airport("B", "B city", "B country");
        airport1.setId(1L);
        assertEquals(1L, airport1.getId());
        assertEquals("B", airport1.getName());
        assertEquals("B city", airport1.getCity());
        assertEquals("B country", airport1.getCountry());
        assertEquals(airport1.toString(), "Airport{id=1, name='B', city='B city', country='B country'}");
        Airport airport2 = new Airport(1L, "B", "B city", "B country");
        assertEquals(1L, airport2.getId());
        assertEquals("B", airport2.getName());
        assertEquals("B city", airport2.getCity());
        assertEquals("B country", airport2.getCountry());
        assertEquals(airport2.toString(), "Airport{id=1, name='B', city='B city', country='B country'}");
        assertEquals(airport1.hashCode(), airport2.hashCode());
        airport2.setCity("A");
        assertNotEquals(airport1.hashCode(), airport2.hashCode());

    }
}