import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.Iterator;

import dao.UserDAO;
import dao.entity.UserEntity;
import org.junit.Test;
import rest.UserRest;

public class ProjectTest {
	@Test
	public void testCalA() throws Exception {
		assertEquals(4, 2+2);
	}

	@Test
	public void usersNotEqual() {
		UserRest ur = mock(UserRest.class);
		when(ur.validate("truetoken")).thenReturn("true");
		assertEquals("true", ur.validate("truetoken"));
	}

	@Test
	public void iterator_will_return_hello_world() {
		//подготавливаем
		Iterator i = mock(Iterator.class);
		when(i.next()).thenReturn("Hello").thenReturn("World");
		String result = i.next()+" "+i.next();
		//сравниваем
		assertEquals("Hello World", result);
	}

}