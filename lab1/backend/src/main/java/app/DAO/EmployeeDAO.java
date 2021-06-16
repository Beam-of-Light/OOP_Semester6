package app.DAO;

import app.entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public static List<Employee> getAllEmployees(){
        ConnectionPool cp = ConnectionPool.getConnectionPool();
        try(Connection connection = cp.getConnection();) {
            String sql =
                    "SELECT id, full_name, \"position\"\n" +
                            "\tFROM public.employee;";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Employee> employees = new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt(1);
                String fullName = rs.getString(2);
                String position = rs.getString(3);
                employees.add(new Employee(id, fullName, position));
            }
            st.close();
            cp.releaseConnection(connection);
            return employees;
        } catch (SQLException | InterruptedException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public static List<Employee> getEmployeeForFlight(int flightId){
        ConnectionPool cp = ConnectionPool.getConnectionPool();
        try(Connection connection = cp.getConnection();) {
            String sql =
                    "SELECT employee.id, employee.full_name, employee.position FROM employee\n" +
                            "INNER JOIN employee_flight\n" +
                            "on employee.id = employee_flight.employee_id\n" +
                            "WHERE employee_flight.flight_id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, flightId);
            ResultSet rs = st.executeQuery();
            List<Employee> employees = new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt(1);
                String fullName = rs.getString(2);
                String position = rs.getString(3);
                employees.add(new Employee(id, fullName, position));
            }
            st.close();
            cp.releaseConnection(connection);
            return employees;
        } catch (SQLException | InterruptedException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public static void addEmployee(Employee employee) {
        ConnectionPool cp = ConnectionPool.getConnectionPool();
        try(Connection connection = cp.getConnection();) {
            String sql =
                    "INSERT INTO employee (full_name, position) "
                            + "VALUES (?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, employee.getFullName());
            st.setString(2, employee.getPosition());
            int count = st.executeUpdate();
            st.close();
            cp.releaseConnection(connection);
        } catch (SQLException | InterruptedException e1) {
            e1.printStackTrace();
        }
    }


    public static void updateEmployee(Employee employee) {
        ConnectionPool cp = ConnectionPool.getConnectionPool();
        try(Connection connection = cp.getConnection();) {
            String sql =
                    "UPDATE public.employee\n" +
                            "\tSET full_name=?, \"position\"=?\n" +
                            "\tWHERE id = ?;";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, employee.getFullName());
            st.setString(2, employee.getPosition());
            st.setInt(3, employee.getId());
            int count = st.executeUpdate();
            st.close();
            cp.releaseConnection(connection);
        } catch (SQLException | InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public static void deleteEmployee(int employeeID) {
        ConnectionPool cp = ConnectionPool.getConnectionPool();
        try(Connection connection = cp.getConnection();) {
            String sql =
                    "DELETE FROM public.employee\n" +
                            "\tWHERE employee.id = ?;";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, employeeID);
            int count = st.executeUpdate();
            st.close();
            cp.releaseConnection(connection);
        } catch (SQLException | InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}