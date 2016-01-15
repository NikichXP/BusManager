package com.busmanager.rest.v1;

import javax.inject.Named;

import com.busmanager.dao.RouteDAO;
import com.busmanager.dao.entity.Route;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

@Api (name = "route")
public class RouteAPI {
		
	@ApiMethod (name = "getById", path = "get", httpMethod = "GET")
	public Route getById (@Named ("id") String id) {
		try {
			return RouteDAO.getRoute (id);
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
