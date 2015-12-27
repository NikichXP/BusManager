package rest;

import com.google.gson.Gson;
import dao.BusDAO;
import dao.RouteDAO;
import dao.entity.RouteEntity;

import javax.ws.rs.*;

@Path("route")
public class RouteRest {

    private static Gson gson = new Gson();
    private static RouteDAO dao = RouteDAO.getInstance();
    private static DataContainer dc = DataContainer.getInstance();

    @GET
    @Path("start")
    public String startRoute (@QueryParam("from")String from, @QueryParam("busid")String carid,
                              @QueryParam("token") String token, @QueryParam("tripnumber") String tripid, @QueryParam("to") String to) {
        /*

        <!--- This is for future release ---!>

        if (DataContainer.checkToken(token)) {
            RouteEntity ent = RouteDAO.getRoute(routeid);
            if (ent == null) {
                return gson.toJson(new Error ("Wrong id"));
            }
            ent.setToken(token);
            ent.setCar(BusDAO.getBus(carid));
            DataContainer.addActiveRoute(ent);
            return gson.toJson(ent);
        }
        return gson.toJson(new Error ("Wrong token"));
        */
        RouteEntity ent = new RouteEntity(Integer.parseInt(tripid), Integer.parseInt(from), Integer.parseInt(to));
        ent.setToken(token);
        ent.setCar(BusDAO.getBus(carid));
        dc.addActiveRoute(ent);
        return gson.toJson(ent);
    }

    @GET
    @Path("get")
    public String getRoute (@QueryParam("token")String token) {
        if (!DataContainer.checkToken(token)) {
            return gson.toJson(new Error ("Auth failed"));
        }
        RouteEntity ent = dc.getRoute(token);
        if (ent == null) {
            return gson.toJson(new Error ("No such route with this token"));
        }
        return gson.toJson(ent);
    }

    @GET
    @Path("addclient")
    public String addClient (@QueryParam("token")String token, @QueryParam("seatnumber")String seatNumber) {
        DataContainer.getRoute(token).addClient(Integer.parseInt(seatNumber));
        return gson.toJson(new Error ("Success"));
    }

    @GET
    @Path("deleteclient")
    public String deleteClient (@QueryParam("token")String token, @QueryParam("seatnumber")String seatNumber) {
        DataContainer.getRoute(token).removeClient(Integer.parseInt(seatNumber));
        return gson.toJson(new Error ("Success"));
    }
}
