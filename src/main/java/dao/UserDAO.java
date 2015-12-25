package dao;

import dao.entity.UserEntity;
import rest.DataContainer;
import rest.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserDAO {

    private static UserDAO instance = null;
    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }
    private UserDAO () {
    }

    public static UserEntity getUser(String login, String pass) {
        ResultSet rs = null;
        try {
            rs = Query.query("Select * from user where login = \"" + login + "\" and password = \"" + pass + "\";");
            if (!rs.first()) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        UUID uuid = UUID.randomUUID();
        try {
            UserEntity u = new UserEntity(rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("car"),
                    rs.getString("plate"),
                    rs.getInt("capacity"),
                    uuid.toString()
            );
            DataContainer.addToken(uuid.toString(), u);
            return u;
        } catch (SQLException e) {
            return null;
        }
    }

    public static boolean createUser(String login, String pass, String name, String surname, String car, String plate, int capacity) {
        try {
            Query.updateQuery("INSERT INTO user (`login`, `password`, `name`, `surname`, `car`, `plate`, `capacity`) VALUES ('" +
                    login + "', '" + pass + "', '" + name + "', '" + surname + "', '" + car + "', '" + plate +
                    " ', '" + capacity + "');");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
