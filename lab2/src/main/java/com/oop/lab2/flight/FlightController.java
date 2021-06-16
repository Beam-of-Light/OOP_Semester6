package com.oop.lab2.flight;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @RolesAllowed({"Admin", "Dispatcher"})
    @GetMapping
    public List<Flight> getFlights() {
        System.out.println("Somebody to love!");
        return flightService.getFlights();
    }

    @RolesAllowed("Admin")
    @PostMapping
    public void addFlight(@RequestBody FlightInfo flight) {
        this.flightService.addFlight(flight);
    }

    @RolesAllowed("Admin")
    @DeleteMapping(path = "{flightId}")
    public void deleteFlight(@PathVariable("flightId") Long id) {
        flightService.deleteFlight(id);
    }

    @RolesAllowed("Admin")
    public void updateFlight(@RequestBody FlightInfo flight){
        this.flightService.updateFlight(flight);
    }
}
