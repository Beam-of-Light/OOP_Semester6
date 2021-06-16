package com.oop.lab2.employee;

import com.oop.lab2.airport.Airport;
import com.oop.lab2.airport.AirportRepository;
import com.oop.lab2.airport.AirportService;
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
class EmployeeServiceTest {


    @Autowired
    private EmployeeService service;

    /**
     * Create a mock implementation of the WidgetRepository
     */
    @MockBean
    private EmployeeRepository repository;

    @Test
    void checkUpdate() {
        Employee newVersion = new Employee(2L, "A", "A position");
        Employee oldVersion = new Employee(2L, "B", "B position");
        service.updateEmployeeProps(oldVersion, newVersion);
        assertEquals(oldVersion, newVersion);
    }


    @Test
    @DisplayName("Test findById Success")
    void testGetAll() {
        Employee employee = new Employee(1L, "A", "A");
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        doReturn(employees).when(repository).findAll();

        List<Employee> returnedEmployees = service.getEmployees();


        assertEquals(returnedEmployees.size(), 1);
        assertEquals(returnedEmployees.get(0).getPosition(), "A");
    }

    @Test
    void testUpdate() {

        Employee employee = new Employee(1L, "A", "A");
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        doReturn(employees).when(repository).findAll();
        doReturn(Optional.of(employees.get(0))).when(repository).findById(1L);
        service.updateEmployee(new Employee(1L, "B", "B"));
        List<Employee> returnedEmployees = service.getEmployees();

        assertEquals(returnedEmployees.get(0).getPosition(), "B");
    }
}