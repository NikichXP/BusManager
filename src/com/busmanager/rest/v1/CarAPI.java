package com.busmanager.rest.v1;

import java.util.List;
import com.busmanager.Text;
import com.busmanager.dao.CarDAO;
import com.busmanager.dao.entity.Car;
import com.google.api.server.spi.config.*;

@Api (name = "car", version = "v1")
public class CarAPI {
	
	@ApiMethod (name = "create", httpMethod = "GET", path = "create")
	public Text createCar (@Named ("model") String model, @Named ("seats") String seats) {
		return new Text (CarDAO.createCar(model, seats));
	}
	
	@ApiMethod (name = "get", httpMethod = "GET", path = "get")
	public Car getCar (@Named ("id") String id) {
		return CarDAO.getCar(id);
	}
	
	@ApiMethod (name = "searchName", httpMethod = "GET", path = "search")
	public List<Car> searchCarByName (@Named ("name") String name) {
		return CarDAO.searchCarByName(name);
	}
	
	@ApiMethod (name = "searchSeats", httpMethod = "GET", path = "minSeats")
	public List<Car> searchCarsByMinSeats (@Named ("seats") String seats) {
		return CarDAO.filterCarMinSeats(Integer.parseInt(seats));
	}
	
}
