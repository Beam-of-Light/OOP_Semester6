package app.entities;

public class EmployeeFlight {
    private int employeeId;
    private int flightId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    @Override
    public String toString() {
        return "EmployeeFlight{" +
                "employeeId=" + employeeId +
                ", flightId=" + flightId +
                '}';
    }

    public EmployeeFlight(int employeeId, int flightId) {
        this.employeeId = employeeId;
        this.flightId = flightId;
    }
}
