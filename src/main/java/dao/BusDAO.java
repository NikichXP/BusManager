package dao;

import com.google.gson.JsonElement;
import dao.entity.BusEntity;
import rest.Query;

import javax.ejb.Singleton;
import java.sql.ResultSet;
import java.util.ArrayList;

@Singleton
public class BusDAO {
    private static BusDAO instance = null;
    public static BusDAO getInstance() {
        if (instance == null) {
            instance = new BusDAO();
        }
        return instance;
    }
    private BusDAO () {
    }


    public static boolean create(int seats, String name) {
        try {
            Query.updateQuery("INSERT INTO `bus`.`bus` (`name`, `seats`) VALUES ('"+name+"', '"+seats+"');");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static BusEntity getBus(String carid) {
        BusEntity ret = null;
        try {
            ResultSet rs = Query.query("SELECT * FROM bus.bus WHERE id = " + carid);
            rs.first();
            return new BusEntity(rs.getInt("id"), rs.getString("name"), rs.getInt("seats"));
        } catch (Exception e) {
            return null;
        }
    }

    public static ArrayList<BusEntity> getAllCars() {
        ArrayList<BusEntity> ret = new ArrayList<>();
        try {
            ResultSet rs = Query.query("SELECT * FROM bus.bus");
            while (rs.next()) {
                ret.add(new BusEntity(rs.getInt("id"), rs.getString("name"), rs.getInt("seats")));
            }
            return ret;
        } catch (Exception e) {
            return null;
        }
    }
}
