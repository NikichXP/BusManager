package rest;

import com.google.gson.Gson;
import dao.BusDAO;
import dao.RouteDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("data")
public class DataRest {

    Gson gson = new Gson();

    @GET
    @Path("getCars")
    public String getCars () {
        return gson.toJson(BusDAO.getAllCars());
    }

    @GET
    @Path("getTowns")
    public String getTowns() {
        return gson.toJson(RouteDAO.getCity());
    }
}
