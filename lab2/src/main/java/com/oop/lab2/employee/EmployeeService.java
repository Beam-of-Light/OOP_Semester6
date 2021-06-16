package com.oop.lab2.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    public void addEmployee(Employee employee) {
        repository.save(employee);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    public void updateEmployeeProps(Employee oldVersion, Employee newVersion) {
        if (newVersion.getFullName() != null
                && !oldVersion.getFullName().equals(newVersion.getFullName())
                && newVersion.getFullName().length() > 0
        ) {
            oldVersion.setFullName(newVersion.getFullName());
        }

        if (newVersion.getPosition() != null
                && !oldVersion.getPosition().equals(newVersion.getPosition())
                && newVersion.getPosition().length() > 0
        ) {
            oldVersion.setPosition(newVersion.getPosition());
        }
    }

    @Transactional
    public void updateEmployee(Employee newVersion) {
        Employee oldVersion = repository.findById(newVersion.getId())
                .orElseThrow(() ->  new IllegalStateException("Employee does not exist"));
        updateEmployeeProps(oldVersion, newVersion);
    }

    public List<Employee> getEmployeesByFlightId(Long flightId) {
        return repository.findByFlightId(flightId);
    }
}