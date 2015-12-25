package rest;

import java.sql.*;
import javax.ws.rs.*;

@Path("test")
public class TestRest {

    @GET
    @Path("ping")
    /**
     * Checks if server and API is working
     */
    public String sendMail() {
        return "1";
    }

    @GET
    @Path ("echo")
    public String echo (@QueryParam("text")String text) {
        return text;
    }

    @GET
    @Path("userSelect")
    public String userSelect() {
        String ret = "";
        ResultSet r = null;
        try {
            r = Query.query("Select * from user;");
            while (r.next()) {
                ret += r.getNString("login") + r.getNString("password") + "\n";
            }
        } catch (Exception e) {
            ret = e.toString();
        }
        return ret;
    }

}
