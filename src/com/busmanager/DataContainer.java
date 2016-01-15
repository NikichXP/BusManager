package com.busmanager;

import java.util.HashMap;

import com.busmanager.dao.RouteDAO;
import com.busmanager.dao.entity.*;

public class DataContainer {
	
	private static HashMap<String, User> activeSessions = new HashMap<>();
	private static HashMap<String, Route> activeRoutes = new HashMap<>();
	
	public static void addToken (User u, String t) {
		activeSessions.put(t, u);
	}
	
	public static void addToken (User u) {
		activeSessions.put(u.getToken(), u);
	}
	
	public static boolean checkToken (String t) {
		return activeSessions.containsKey(t);
	}
	
	public static User getByToken (String t) {
		return activeSessions.get(t);
	}

	public static boolean startRoute(String id, String token) {
		if (activeSessions.get(token) != null) {
			Route r = RouteDAO.getRoute(id);
			System.out.println(r);
			if (r != null) {
				activeRoutes.put(token, RouteDAO.getRoute(id));
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
