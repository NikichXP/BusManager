package com.busmanager.rest.v1;

import com.busmanager.Text;
import com.busmanager.dao.entity.*;
import com.google.api.server.spi.config.*;
import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;
import java.util.List;

@Api (name = "test", version = "v1")
public class TestAPI {
	
	static {
		ObjectifyService.begin();
		ObjectifyService.register(User.class);
		ObjectifyService.register(City.class);
		ObjectifyService.register(Car.class);
		ObjectifyService.register(Route.class);
		System.out.println("reg complete");
    }
	
	@ApiMethod (
			name = "ping",
			httpMethod = "GET"
			)
	public Text ping () {
		return new Text("text");
	}
	
	@ApiMethod (
			name = "userList",
			httpMethod = "GET",
			path = "userList"
			)
	public List<User> getUser () {
		List<User> ret = ofy().load().type(User.class).list();
		return ret;
	}

}
