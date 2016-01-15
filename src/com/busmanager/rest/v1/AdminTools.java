package com.busmanager.rest.v1;

import java.util.ArrayList;
import java.util.List;

import com.busmanager.Text;
import com.busmanager.dao.RouteDAO;
import com.busmanager.dao.entity.City;
import com.google.api.server.spi.config.*;
import static com.googlecode.objectify.ObjectifyService.ofy;

@Api(name = "admin", version = "v1")
public class AdminTools {
	
	@ApiMethod (name = "city.create", path = "createCity", httpMethod = "GET")
	public Text createCity (@Named ("name") String name, @Named ("x") String x, @Named ("y") String y) {
		try {
			City c = new City (name, Double.parseDouble(x), Double.parseDouble(y));
			ofy().save().entity(c).now();
			return new Text ("City saved");
		} catch (Exception e) {
			return new Text (e.toString());
		}
	}
	
	@ApiMethod (name = "route.create", path = "createRoute", httpMethod = "GET")
	public Text createRoute (@Named("title") String title, @Named ("from") String from, @Named ("to") String to,
								@Named("time") String time, @Named ("days") String days, @Named ("carid") String carId, 
								@Named ("id") String id) {
		String sync = RouteDAO.createRoute(id, title, from, to, time, days);
		return new Text (sync);
	}

	//  <--- Get-All Methods! Delete on release! --->
	
	@ApiMethod(name = "car.getAll", path = "listCar", httpMethod = "GET")
	public List<Object> listCars() {
		return ofy().load().kind("Car").list();
	}

	@ApiMethod(name = "user.getAll", path = "listUser", httpMethod = "GET")
	public List<Object> listUsers() {
		return ofy().load().kind("User").list();
	}
	
	@ApiMethod(name = "city.getAll", path = "listCity", httpMethod = "GET")
	public List<Object> listCities() {
		return ofy().load().kind("City").list();
	}
	
	@ApiMethod(name = "route.getAll", path = "listRoute", httpMethod = "GET")
	public List<Object> listRoutes() {
		return ofy().load().kind("Route").list();
	}
	
	@ApiMethod(name = "listAll", path = "listAll", httpMethod = "GET")
	public List<List<Object>> listAll() {
		List<List<Object>> gl = new ArrayList<>();
		List<Object> l1 = ofy().load().kind("User").list();
		List<Object> l2 = ofy().load().kind("City").list();
		List<Object> l3 = ofy().load().kind("Car").list();
		List<Object> l4 = ofy().load().kind("Route").list();
		gl.add(l1);
		gl.add(l3);
		gl.add(l2);
		gl.add(l4);
		return gl;
	}

}
