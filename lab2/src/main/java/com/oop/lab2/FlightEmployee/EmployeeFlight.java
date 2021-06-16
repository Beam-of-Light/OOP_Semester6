package com.oop.lab2.FlightEmployee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
@IdClass(EmployeeFlight.class)
public class EmployeeFlight implements Serializable {
    @Id
    public Long employeeId;
    @Id
    public Long flightId;

    public EmployeeFlight() {

    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeFlight)) return false;
        EmployeeFlight that = (EmployeeFlight) o;
        return getEmployeeId().equals(that.getEmployeeId()) && getFlightId().equals(that.getFlightId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getFlightId());
    }

    @Override
    public String toString() {
        return "EmployeeFlight{" +
                "employeeId=" + employeeId +
                ", flightId=" + flightId +
                '}';
    }

    public EmployeeFlight(Long employeeId, Long flightId) {
        this.employeeId = employeeId;
        this.flightId = flightId;
    }
}
