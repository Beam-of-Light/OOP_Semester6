package com.oop.lab2.FlightEmployee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="flight_employees")
public class EmployeeFlightController {

    private final EmployeeFlightService employeeService;

    @Autowired
    public EmployeeFlightController(EmployeeFlightService employeeService) {
        this.employeeService = employeeService;
    }

    @RolesAllowed({"Admin", "Dispatcher"})
    @PostMapping
    public void addFlightEmployer(@RequestBody EmployeeFlight employeeFlight) {
        this.employeeService.addFlightEmployee(employeeFlight);
    }

    @RolesAllowed({"Admin", "Dispatcher"})
    @DeleteMapping
    public void deleteFlightEmployer(@RequestBody EmployeeFlight employeeFlight) {
        employeeService.deleteFlight(employeeFlight);
    }

}
