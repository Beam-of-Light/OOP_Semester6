package app.DAO;

import app.entities.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserAccountDAO {

    public static UserAccount getUser(String userName, String password) {
        ConnectionPool cp = ConnectionPool.getConnectionPool();
        try(Connection connection = cp.getConnection();) {
            String sql =
                    "SELECT * FROM \"user\" WHERE (login =\'" + userName + "\'and password = \'" + password + "\')";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<UserAccount> users = new ArrayList<UserAccount>();
            while(rs.next()) {
                int id = rs.getInt(1);
                String login = rs.getString(2);
                String pass = rs.getString(3);
                String role = rs.getString(4);
                users.add(new UserAccount(id, login, pass, role));
            }
            st.close();
            cp.releaseConnection(connection);
            if (users.size() > 0)
                return users.get(0);
            return null;
        } catch (SQLException | InterruptedException e1) {
            e1.printStackTrace();
        }
        return null;
    }

}
