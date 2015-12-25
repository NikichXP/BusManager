package rest;

import com.google.gson.Gson;
import dao.entity.RouteEntity;

import javax.ws.rs.*;
import java.util.ArrayList;

@Path("route")
public class RouteRest {

    private static ArrayList<RouteEntity> routes = new ArrayList<>();

    private static Gson gson = new Gson();

    @GET
    @Path("create")
    public String createRoute (@QueryParam("fromx")String fromx, @QueryParam("tox")String tox,
                               @QueryParam("fromy")String fromy, @QueryParam("toy")String toy,
                               @QueryParam("token") String token) {
        try {
            routes.add(new RouteEntity(Double.parseDouble(fromx), Double.parseDouble(fromy), Double.parseDouble(tox),
                    Double.parseDouble(toy), token));
        } catch (NumberFormatException ex) {
            return gson.toJson(new Error("NumberFormatException" + ex.toString()));
        } catch (Exception e) {
            return gson.toJson(new Error(e.toString()));
        }
        for (RouteEntity r : routes) {
            if (token.equals(r.getToken())) {
                return gson.toJson(r);
            }
        }
        return gson.toJson(new Error("Unknown fail"));
    }

    @GET
    @Path("get")
    /**
     * Names of passengers and coordinates
     */
    public String routeGet (@QueryParam("token")String token) {
        for (RouteEntity r : routes) {
            if (token.equals(r.getToken())) {
                return gson.toJson(r);
            }
        }
        return gson.toJson(new Error("No such token registered"));
    }

    @GET
    @Path("addStop")
    public String addPassenger (@QueryParam("token")String token, @QueryParam("x")String x, @QueryParam("y")String y,
                                @QueryParam("name")String name) {
        try {
            for (RouteEntity r : routes) {
                if (token.equals(r.getToken())) {
                    r.addStop(name, Double.parseDouble(x), Double.parseDouble(y));
                    return gson.toJson(r);
                }
            }
        } catch (NumberFormatException ex) {
            return gson.toJson(new Error(ex.toString()));
        }
        catch (Exception e) {
            return gson.toJson(new Error("Unknown response"));
        }
        return gson.toJson(new Error("No such token"));
    }

    @GET
    @Path("removeclient")
    public String removePassenger (@QueryParam("token")String token, @QueryParam("name")String name) {
        for (RouteEntity r : routes) {
            if (token.equals(r.getToken())) {
                r.removePassenger(name);
                return gson.toJson(r);
            }
        }
        return gson.toJson(new Error("Unknown fail"));
    }

    @GET
    @Path ("endroute")
    public String endRoute (@QueryParam("token") String token) {
        for (int i = 0; i < routes.size(); i++) {
            if (token.equals(routes.get(i))) {
                routes.remove(i);
                return "road ends";
            }
        }
        return gson.toJson(new Error("Unknown fail"));
    }

}
