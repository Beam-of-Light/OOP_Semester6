package com.oop.lab2.airport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class AirportServiceTest {
    /**
     * Autowire in the service we want to test
     */
    @Autowired
    private AirportService service;

    /**
     * Create a mock implementation of the WidgetRepository
     */
    @MockBean
    private AirportRepository repository;

    @Test
    void testGetAll() {
        Airport airport = new Airport(1L, "A", "A", "A");
        ArrayList<Airport> airportList = new ArrayList<>();
        airportList.add(airport);
        doReturn(airportList).when(repository).findAll();

        List<Airport> returnedWidget = service.getAirports();


        assertEquals(returnedWidget.size(), 1);
    }

    @Test
    void testUpdate() {

        Airport widget = new Airport(1L, "A", "A", "A");
        ArrayList<Airport> airportList = new ArrayList<>();
        airportList.add(widget);
        doReturn(airportList).when(repository).findAll();
        doReturn(Optional.of(airportList.get(0))).when(repository).findById(1L);
        service.updateEmployee(new Airport(1L, "B", "B", "B"));
        List<Airport> returnedWidget = service.getAirports();

        assertEquals(returnedWidget.get(0).getName(), "B");
    }
}
