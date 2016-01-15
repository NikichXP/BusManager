package com.busmanager.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;
import com.busmanager.dao.entity.City;

public class CityDAO {
	
	public static City findByName (String name) {
		return (City) ofy().load().kind("City").filter("name", name).first().now();
	}
	
	public static City findById (String id) {
		return (City) ofy().load().kind("City").id(id).now();
	}
	
	public static boolean createCity (double x, double y, String name) {
		ofy().save().entity(new City(name, x, y)).now();
		return true;
	}
	
	public static boolean deleteCityById (String id) {
		ofy().delete().type(City.class).id(id);
		return true;
	}
	
	public static boolean deleteCityById (long id) {
		ofy().delete().type(City.class).id(id);
		return true;
	}
	
	public static boolean deleteCityByName (String name) {
		City c = (City) ofy().load().kind("City").filter("name", name).first().now();
		ofy().delete().entity(c);
		return true;
	}
	
	public static City update (long id, double x, double y, String name) {
		deleteCityById(id);
		City c = new City(id, name, x, y);
		ofy().save().entity(c).now();
		return c;
	}
	
}
