package app.DAO;

import app.entities.Airport;
import app.entities.Flight;
import app.entities.FlightInfo;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {
    public static List<Flight> getAllFlights() {
        ConnectionPool cp = ConnectionPool.getConnectionPool();
        try(Connection connection = cp.getConnection();) {
            String sql =
                    "SELECT fl.id, fl.departure, f.id, f.name, f.city, f.country, t.id, t.name, t.city, t.country\n" +
                            "FROM flight as fl\n" +
                            "INNER JOIN airport as f ON f.id = fl.from\n" +
                            "INNER JOIN airport as t ON t.id = fl.to;";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Flight> flights = new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt(1);
                LocalDateTime dep = rs.getTimestamp(2).toLocalDateTime();
                int fromId = rs.getInt(3);
                String fromName = rs.getString(4);
                String fromCity = rs.getString(5);
                String fromCountry = rs.getString(6);
                Airport from = new Airport(fromId, fromName, fromCity, fromCountry);
                int toId = rs.getInt(7);
                String toName = rs.getString(8);
                String toCity = rs.getString(9);
                String toCountry = rs.getString(10);
                Airport to = new Airport(toId, toName, toCity, toCountry);
                flights.add(new Flight(id, from, to, dep));
            }
            st.close();
            cp.releaseConnection(connection);
            return flights;
        } catch (SQLException | InterruptedException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public static void addFlight(FlightInfo flightInfo){
        ConnectionPool cp = ConnectionPool.getConnectionPool();
        try(Connection connection = cp.getConnection();) {
            String sql =
                    "INSERT INTO public.flight(\n" +
                            "\"to\", departure, \"from\")\n" +
                            "\tVALUES (?, ?, ?);";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, flightInfo.getTo());
            st.setTimestamp(2, new Timestamp(flightInfo.getDeparture()));
            st.setInt(3, flightInfo.getFrom());
            int count = st.executeUpdate();
            st.close();
            cp.releaseConnection(connection);
        } catch (SQLException | InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public static void updateFlight(FlightInfo flightInfo){
        ConnectionPool cp = ConnectionPool.getConnectionPool();
        try(Connection connection = cp.getConnection();) {
            String sql =
                    "UPDATE public.flight\n" +
                            "\tSET \"to\"=?, departure=?, \"from\"=?\n" +
                            "\tWHERE id = ?;";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, flightInfo.getTo());
            st.setTimestamp(2, new Timestamp(flightInfo.getDeparture()));
            st.setInt(3, flightInfo.getFrom());
            st.setInt(4, flightInfo.getId());
            int count = st.executeUpdate();
            st.close();
            cp.releaseConnection(connection);
        } catch (SQLException | InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public static void deleteFlight(int flightId){

        ConnectionPool cp = ConnectionPool.getConnectionPool();
        try(Connection connection = cp.getConnection();) {
            String sql =
                    "DELETE FROM public.flight\n" +
                            "\tWHERE id = ?;";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, flightId);
            int count = st.executeUpdate();
            st.close();
            cp.releaseConnection(connection);
        } catch (SQLException | InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
