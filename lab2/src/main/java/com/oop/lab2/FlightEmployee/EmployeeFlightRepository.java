package com.oop.lab2.FlightEmployee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeFlightRepository extends JpaRepository<EmployeeFlight, Long> {

}
