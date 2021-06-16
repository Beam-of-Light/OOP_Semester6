package com.oop.lab2.employee;


import com.oop.lab2.airport.Airport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testGetSet () {
        Employee employee = new Employee(1L, "B", "B position");
        assertEquals(1L, employee.getId());
        assertEquals("B", employee.getFullName());
        assertEquals("B position", employee.getPosition());

        employee.setId(2L);
        employee.setFullName("A");
        employee.setPosition("A position");

        assertEquals(2L, employee.getId());
        assertEquals("A", employee.getFullName());
        assertEquals("A position", employee.getPosition());
    }

    @Test
    void testToString() {

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFullName("B");
        employee.setPosition("B position");
        assertEquals(1L, employee.getId());
        assertEquals("B", employee.getFullName());
        assertEquals("B position", employee.getPosition());
        assertEquals(employee.toString(), "Employee{id=1, fullName='B', position='B position'}");
    }

    @Test
    void testEquals() {
        Employee employee = new Employee("B", "B position");
        employee.setId(1L);
        assertEquals(1L, employee.getId());
        Employee employee1 = new Employee(1L, "B", "B position");
        assertEquals(1L, employee1.getId());
        assertEquals(employee, employee1);
        employee1.setPosition("A");
        assertNotEquals(employee, employee1);
    }

    @Test
    void testHashCode() {
        Employee employee = new Employee(1L, "B", "B position");
        assertEquals(1L, employee.getId());
        Employee employee1 = new Employee(1L, "B", "B position");
        assertEquals(1L, employee1.getId());
        assertEquals(employee.hashCode(), employee1.hashCode());
        employee1.setPosition("A");
        assertNotEquals(employee.hashCode(), employee1.hashCode());

    }
}