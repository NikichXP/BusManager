package dao;

import com.google.gson.JsonElement;
import dao.entity.RouteEntity;
import rest.*;

import javax.ejb.Singleton;
import java.sql.ResultSet;
import java.util.ArrayList;

@Singleton
public class RouteDAO {

    private static RouteDAO instance = null;
    public static RouteDAO getInstance() {
        if (instance == null) {
            instance = new RouteDAO();
        }
        return instance;
    }
    private RouteDAO () {
    }

    public static boolean create(int from, int to, String time, String days) {
        try {
            Query.updateQuery("INSERT INTO `bus`.`route` (`from`, `to`, `time`, `days`) VALUES ('"+from+
                    "', '"+to+"', '"+time+"', '"+days+"');");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static RouteEntity getRoute(String routeid) {
        try {
            ResultSet rs = Query.query("SELECT * FROM bus.route WHERE id = " + routeid);
            rs.first();
            return new RouteEntity(rs.getInt("id"), rs.getInt("from"), rs.getInt("to"));
        } catch (Exception e) {
            return null;
        }

    }

    public static ArrayList<City> getCity() {
        ArrayList<City> ret = new ArrayList<>();
        try {
            ResultSet rs = Query.query("SELECT * FROM bus.city");
            while (rs.next()) {
                ret.add(new City(rs.getInt("id"), rs.getString("name")));
            }
            return ret;
        } catch (Exception e) {
            return null;
        }
    }

    public static class City {
        int id;
        String name;

        public City(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
