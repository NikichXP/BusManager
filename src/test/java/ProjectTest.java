import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.Iterator;

import dao.UserDAO;
import dao.entity.UserEntity;
import org.junit.Test;

public class ProjectTest {
	@Test
	public void testCalA() throws Exception {
		assertEquals(4, 2+2);
	}

	@Test
	public void usersNotEqual() {
		UserDAO mock = mock(UserDAO.class);
		when(mock.getUser("admin", "adminpass")).thenReturn(new UserEntity(1, "admin", "adminpass", "Admin", "Adminovich", "Brabus", "AA5555AA", 1, "sometoken"));
		UserEntity u1 = new UserEntity(2, "Vasya", "vasss", "Vasya", "Clean", "Volga", "AA5555AA", 1, "sometoken");
		UserEntity u2 = mock.getUser("admin", "adminpass");
		assertNotEquals(u1.getId(), u2.getId());
	}

	@Test
	public void iterator_will_return_hello_world() {
		//подготавливаем
		Iterator i = mock(Iterator.class);
		when(i.next()).thenReturn("Hello").thenReturn("World");
		//выполняем
		String result = i.next()+" "+i.next();
		//сравниваем
		assertEquals("Hello World", result);
	}

}