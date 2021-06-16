package com.oop.lab2.flight;

import static org.junit.jupiter.api.Assertions.*;

import com.oop.lab2.airport.Airport;
import com.oop.lab2.airport.AirportRepository;
import com.oop.lab2.airport.AirportService;
import com.oop.lab2.employee.Employee;
import com.oop.lab2.employee.EmployeeService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class FlightServiceTest {
    @Autowired
    private FlightService service;

    /**
     * Create a mock implementation of the WidgetRepository
     */
    @MockBean
    private AirportRepository airportRepository;

    @MockBean
    private FlightRepository flightRepository;




    @Test
    void checkUpdate() {
        LocalDateTime now = LocalDateTime.now();
        Flight newVersion = new Flight(2L, new Airport(2L, "A", "A", "A"), new Airport(3L, "B", "B", "B"), now);
        Flight oldVersion = new Flight(2L, new Airport(2L, "C", "C", "C"), new Airport(3L, "B", "B", "B"), now);
        service.updateFlightProps(oldVersion, newVersion);
        assertEquals(oldVersion, newVersion);
    }

    @Test
    void getAll() {
        Flight flight = new Flight(1L, new Airport(2L, "A" ,"A", "A"), new Airport(3L, "B", "B", "B"), LocalDateTime.now());
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(flight);
        doReturn(flights).when(flightRepository).findAll();

        List<Flight> returnedWidget = service.getFlights();


        assertEquals(returnedWidget.size(), 1);
        assertEquals(returnedWidget.get(0).getId(), 1L);
    }

    @Test
    void addFlightTest() {

        Airport airport1 = new Airport(2L, "A", "A", "A");
        Airport airport2 = new Airport(3L, "A", "A", "A");
        ArrayList<Airport> airportList = new ArrayList<>();
        airportList.add(airport1);
        airportList.add(airport2);
        doReturn(airportList).when(airportRepository).findAll();
        doReturn(Optional.of(airportList.get(0))).when(airportRepository).findById(2L);
        doReturn(Optional.of(airportList.get(1))).when(airportRepository).findById(3L);

        FlightInfo newFlight = new FlightInfo(1L, 2L, 3L, 4L);

        service.addFlight(newFlight);
        /*List<Flight> returnedWidget = service.getFlights();
        assertEquals(returnedWidget.size(), 1);
        assertEquals(returnedWidget.get(0).getId(), 1L);*/
    }

    @Test
    void testUpdate() {

        Airport airport1 = new Airport(4L, "A", "A", "A");
        Airport airport2 = new Airport(3L, "B", "B", "B");
        ArrayList<Airport> airportList = new ArrayList<>();
        airportList.add(airport1);
        airportList.add(airport2);
        doReturn(airportList).when(airportRepository).findAll();
        doReturn(Optional.of(airportList.get(0))).when(airportRepository).findById(4L);
        doReturn(Optional.of(airportList.get(1))).when(airportRepository).findById(3L);
        Flight flight = new Flight(1L, new Airport(2L, "A" ,"A", "A"), new Airport(3L, "B", "B", "B"), LocalDateTime.now());
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(flight);
        doReturn(flights).when(flightRepository).findAll();
        doReturn(Optional.of(flights.get(0))).when(flightRepository).findById(1L);
        FlightInfo flight2 = new FlightInfo(1L, 4L, 3L, 10L);
        service.updateFlight(flight2);

        assertEquals(service.getFlights().get(0).getFrom().getId(), 4);
    }
}