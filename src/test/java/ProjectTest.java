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
	public void usersEqual() {
		UserDAO dao = mock(UserDAO.class);
		when(UserDAO.getUser("admin", "adminpass")).thenReturn(new UserEntity(1, "admin", "adminpass", "Admin", "Adminovich", "Brabus", "AA5555AA", 1, "sometoken"));
		UserEntity u1 = new UserEntity(1, "admin", "adminpass", "Admin", "Adminovich", "Brabus", "AA5555AA", 1, "sometoken");
		UserEntity u2 = UserDAO.getUser("admin", "adminpass");
		assertEquals(u1, u2);
	}

}