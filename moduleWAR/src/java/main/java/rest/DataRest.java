package rest;

import com.google.gson.Gson;
import dao.BusDAO;
import dao.RouteDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("data")
public class DataRest {

	Gson gson = new Gson();

	@GET
	@Path("getCars")
	public String getCars() {
		return "{\"cars\":" + gson.toJson(BusDAO.getAllCars()) + "}";
	}

	@GET
	@Path("getTowns")
	public String getTowns() {
		return "{\"towns\":" + gson.toJson(RouteDAO.getCity()) + "}";
	}

	@GET
	@Path("/{arg}")
	public String getArg(@PathParam("arg") String arg) {
		return gson.toJson(new Error("No such path: " + arg));
	}

	@GET
	@Path("/{arg}/{argv}")
	public String getArgs(@PathParam("arg") String arg, @PathParam("argv") String argv) {
		return gson.toJson(new Error("No such path: " + arg + " and param " + argv));
	}
}
