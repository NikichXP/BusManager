package rest;

import javax.naming.*;
import javax.sql.DataSource;
import java.sql.*;

/**
 * Util class for making queries
 */
public class Query {

    public static ResultSet query (String query) throws Exception {
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:jboss/datasources/MySQLDS");
        Connection c = ds.getConnection();
        Statement s = c.createStatement();
        s.execute(query);
        return s.getResultSet();
    }

    public static ResultSet updateQuery (String query) throws Exception {
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:jboss/datasources/MySQLDS");
        Connection c = ds.getConnection();
        Statement s = c.createStatement();
        s.executeUpdate(query);
        return s.getResultSet();
    }

}