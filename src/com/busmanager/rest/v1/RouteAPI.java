package com.busmanager.rest.v1;

import com.busmanager.DataContainer;
import com.busmanager.Text;
import com.busmanager.dao.RouteDAO;
import com.busmanager.dao.entity.Route;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;

@Api (name = "route", version = "v1")
public class RouteAPI {
	
	@ApiMethod (name = "startRoute", path = "start", httpMethod = "GET")
	public Text startRoute (@Named ("id") String id, @Named("token") String token) {
		if (DataContainer.startRoute (id, token) == true) {
			return new Text("Success!");
		} else {
			return new Text("Error: route did not started");
		}
	}
		
	@ApiMethod (name = "getById", path = "get", httpMethod = "GET")
	public Route getById (@Named ("id") String id) {
		try {
			return RouteDAO.getRoute (id);
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
