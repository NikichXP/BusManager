package com.busmanager.dao;

import com.busmanager.dao.entity.User;
import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

public class UserDAO {

	public static User create(String login, String pass, String name, String surname) {
		User u = new User(login, pass, name, surname);
		ofy().save().entity(u).now();
		return u;
	}
	
	public static User get (String login, String pass) {
		try {
			return (User) ofy().load().kind("User").filter("login", login).filter("pass", pass).first().now();
		} catch (Exception e) {
			return null;
		}
	}

	public static String delete(long userId) {
		ofy().delete().type(User.class).id(userId);
		return "done";
	}

	public static String delete(String login) {
		try {
			List<Object> ul = ofy().load().kind("User").list();
			for (Object o : ul) {
				System.out.println(o.toString());
			}
			User u = (User) ofy().load().kind("User").filter("login", login).first().now();
			ofy().delete().entity(u).now();
			if (ofy().load().kind("User").list().size() < ul.size()) {
				return "done";
			}
			return "shit";
		} catch (Exception e) {
			return e.toString();
		}
	}

	private static boolean isInit = false;

	static {
		if (isInit == false) {
			ObjectifyService.begin();
			ObjectifyService.register(User.class);
			isInit = true;
		}
	}
}
