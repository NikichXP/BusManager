package com.busmanager.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;
import com.busmanager.dao.entity.*;

public class RouteDAO {

	public static String createRoute(String id, String title, String from, String to, String time, String days, String carId) {
		try {
			long id_ = Long.parseLong(id);
			Route route = new Route (id_, title, from, to, time, days, carId);
			ofy().save().entity(route);
			return "good";
		} catch (Exception e) {
			return e.toString();
		}
		
	}

	public static Route getRoute(String id) {
		return (Route) ofy().load().kind("Route").id(id).now();
	}

}
