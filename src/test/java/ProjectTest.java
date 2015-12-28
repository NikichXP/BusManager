import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.Iterator;

import dao.UserDAO;
import dao.entity.BusEntity;
import org.junit.Test;
import rest.UserRest;
import dao.entity.UserEntity; 
import rest.RouteRest;
import dao.entity.RouteEntity;
import rest.AdminRest;

public class ProjectTest {
	
	@Test
	public void testBusEntity() throws Exception {
		BusEntity be1 = new BusEntity(1, "Icarus", 15);
		BusEntity be2 = new BusEntity(2, "Brabus", 2);
		assertNotEquals(be1, be2);
	}

	@Test
	public void usersEqual() {
		UserRest ur = mock(UserRest.class);
		when(ur.validate("truetoken")).thenReturn("true");
		assertEquals("true", ur.validate("truetoken"));
	}
	
	@Test 
	public void testUserEntity() throws Exception { 
		UserEntity userEnt1 = new UserEntity(1, "admin", "pass", "name", "surname", "car", "no", 1, "someToken"); 
		UserEntity userEnt2 = new UserEntity(1, "admin", "pass", "name", "surname", "car", "no", 1); 
		userEnt2.setToken("someToken"); 
		assertEquals(userEnt1, userEnt2); 
	} 
	
	@Test 
	public void usersNotEqual() { 
		RouteRest rest = mock(RouteRest.class); 
		when(rest.addClient("someToken", "1")).thenReturn("Success!"); 
		assertEquals("Success!", rest.addClient("someToken", "1")); 
	}
	
	@Test 
	public void testRouteEntity () { 
		RouteEntity re1 = new RouteEntity(1, 2, 3); 
		RouteEntity re2 = new RouteEntity(2, 2, 4); 
		assertNotEquals(re1, re2); 
	}

	@Test 
	public void adminTest () { 
		AdminRest rest = mock(AdminRest.class); 
		when(rest.createBus("TATA", "53")).thenReturn("Success!"); 
		assertEquals("Success!", rest.createBus("TATA", "53")); 
	}
}