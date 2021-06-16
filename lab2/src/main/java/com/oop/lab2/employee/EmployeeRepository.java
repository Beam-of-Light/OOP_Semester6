package com.oop.lab2.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e inner join EmployeeFlight ef on e.id = ef.employeeId where ef.flightId =:flightId")
    List<Employee> findByFlightId(@Param("flightId") Long flightId);
}
