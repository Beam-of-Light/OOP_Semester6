package app.DAO;

import app.entities.EmployeeFlight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeFlightDAO {
    public static void addEmployeeToFlight(EmployeeFlight employee) {
        ConnectionPool cp = ConnectionPool.getConnectionPool();
        try(Connection connection = cp.getConnection();) {
            String sql =
                    "INSERT INTO public.employee_flight(\n" +
                            "\tflight_id, employee_id)\n" +
                            "\tVALUES (?, ?);";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, employee.getFlightId());
            st.setInt(2, employee.getEmployeeId());
            int count = st.executeUpdate();
            st.close();
            cp.releaseConnection(connection);
        } catch (SQLException | InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public static void deleteEmployeeFromFlight(EmployeeFlight employee) {
        ConnectionPool cp = ConnectionPool.getConnectionPool();
        try(Connection connection = cp.getConnection();) {
            String sql =
                    "DELETE FROM public.employee_flight\n" +
                            "\tWHERE flight_id = ? and employee_id = ?\n";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, employee.getFlightId());
            st.setInt(2, employee.getEmployeeId());
            int count = st.executeUpdate();
            st.close();
            cp.releaseConnection(connection);
        } catch (SQLException | InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
