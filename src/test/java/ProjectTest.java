import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.Iterator;

import dao.UserDAO;
import dao.entity.UserEntity;
import org.junit.Test;
import rest.RouteRest;
import rest.UserRest;

public class ProjectTest {
	@Test
	public void testCalA() throws Exception {
		assertEquals(4, 2+2);
	}

	@Test
	public void usersEqual() {
		UserRest ur = mock(UserRest.class);
		when(ur.validate("truetoken")).thenReturn("true");
		assertEquals("true", ur.validate("truetoken"));
	}

	@Test
<<<<<<< HEAD
<<<<<<< HEAD
	public void testEntity() throws Exception {
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
=======
=======
>>>>>>> parent of c7a2952... Final
	public void iterator_will_return_hello_world() {
		//подготавливаем
		Iterator i = mock(Iterator.class);
		when(i.next()).thenReturn("Hello").thenReturn("World");
		String result = i.next()+" "+i.next();
		//сравниваем
		assertEquals("Hello World", result);
<<<<<<< HEAD
>>>>>>> parent of c7a2952... Final
=======
>>>>>>> parent of c7a2952... Final
	}

}