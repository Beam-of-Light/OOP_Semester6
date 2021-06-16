package com.oop.lab2.FlightEmployee;


import com.oop.lab2.airport.Airport;
import com.oop.lab2.flight.Flight;
import com.oop.lab2.flight.FlightInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class EmployeeFlightService {
    @Autowired
    private EmployeeFlightRepository repository;

    public void addFlightEmployee(EmployeeFlight employeeFlight) {
        repository.save(employeeFlight);
    }

    public void deleteFlight(EmployeeFlight employeeFlight) {
        repository.delete(employeeFlight);
    }


}