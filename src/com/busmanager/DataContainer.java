package com.busmanager;

import java.util.HashMap;

import com.busmanager.dao.entity.User;

public class DataContainer {
	
	private static HashMap<String, User> activeSessions = new HashMap<>();
	
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

}
