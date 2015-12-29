package rest;

import com.google.gson.Gson;
import dao.BusDAO;
import dao.RouteDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("admin")
public class AdminRest {

    private static Gson gson = new Gson();

    @GET
    @Path("createRoute")
    public String createRoute (@QueryParam("from") String from, @QueryParam("to")String to,
                               @QueryParam("time") String time, @QueryParam("days")String days) {
        if (RouteDAO.create(Integer.parseInt(from), Integer.parseInt(to), time, days)) {
            return gson.toJson(new Error("Success"));
        } else {
            return gson.toJson(new Error("Fail"));
        }
    }

    @GET
    @Path("addBus")
    public String createBus (@QueryParam("name")String name, @QueryParam("seats")String seats) {
        if (BusDAO.create(Integer.parseInt(seats), name)) {
            return gson.toJson(new Error("Success"));
        } else {
            return gson.toJson(new Error("Fail"));
        }
    }
}
