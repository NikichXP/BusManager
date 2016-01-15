package com.busmanager.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;
import java.util.List;

import com.busmanager.dao.entity.Car;

public class CarDAO {

	public static String createCar(String model, String seats) {
		try {
			Car c = new Car (model, Integer.parseInt(seats));
			ofy().save().entity(c).now();
			return "true";
		} catch (Exception e) {
			return e.toString();
		}
	}

	public static Car getCar(String id) {
		return (Car) ofy().load().kind("Car").id(id).now();
	}
	
	public static Car getCar(long id) {
		return (Car) ofy().load().kind("Car").id(id).now();
	}
	
	public static List<Car> filterCarMinSeats (int minSeats) {
		return ofy().load().type(Car.class).filter("seats > ", minSeats).list();
	}

	public static List<Car> searchCarByName(String name) {
		return ofy().load().type(Car.class).filter("model = ", name).list();
	}

}
