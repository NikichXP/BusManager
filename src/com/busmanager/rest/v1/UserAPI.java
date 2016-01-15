package com.busmanager.rest.v1;

import com.busmanager.Text;
import com.busmanager.dao.UserDAO;
import com.busmanager.dao.entity.User;
import com.google.api.server.spi.config.*;

@Api (name = "user", version = "v1")
public class UserAPI {
	
	@ApiMethod (name = "login", httpMethod = "GET", path = "login")
	public User login (@Named ("login") String login, @Named ("pass") String pass) {
		User u = UserDAO.get(login, pass);
		return u;
	}
	
	@ApiMethod (name = "register", httpMethod = "GET", path="register")
	public Text register (@Named ("name") String name, @Named ("pass") String pass, @Named ("login") String login, @Named ("surname") String surname) {
		User u = UserDAO.create(login, pass, name, surname);
		return new Text ("done creating " + u.getId() + u.getName());
	}
	
	@ApiMethod (name = "deleteByKey", httpMethod = "GET", path = "deleteByKey")
	public Text deteleByKey (@Named ("key") String key) {
		return new Text (UserDAO.delete(key));
	}
	
	@ApiMethod (name = "deleteById", httpMethod = "GET", path = "deleteById")
	public Text deteleById (@Named ("key") String key) {
		long id = Long.parseLong(key);
		return new Text (UserDAO.delete(id));
	}
	
	@ApiMethod (path = "ping", httpMethod = "GET")
	public Text ping () {
		return new Text ("ping");
	}
	
}
