package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import java.util.Optional;
import com.revature.exceptions.NewUserHasNonZeroIdException;
import com.revature.exceptions.RegistrationUnsuccessfulException;
import com.revature.repositories.UsersDAO;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.revature.exceptions.UsernameNotUniqueException;
import com.revature.models.User_Role;
import com.revature.models.Users;

public class AuthServiceTest {
	
	private static AuthService authService;
	private static UsersService userService;
	private static UsersDAO userDAO;

	private Users EMPLOYEE_TO_REGISTER;
	private Users GENERIC_EMPLOYEE_1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		authService = new AuthService();
		userService = mock(UsersService.class);
		userDAO = mock(UsersDAO.class);
	}
	
	@Before
	public void setUp() throws Exception {
		EMPLOYEE_TO_REGISTER = new Users(0, "genericEmployee1", "genericPassword", User_Role.employee, null, null, 0);
		GENERIC_EMPLOYEE_1 = new Users(1, "genericEmployee1", "genericPassword", User_Role.employee, null, null, 0);
		new Users(1, "genericManager1", "genericPassword", User_Role.financemanager, null, null, 0);
	}

	@Test
	public void testRegisterFailsWhenUsernameIsTaken() {
		when(userService.getByUsername(anyString())).thenReturn(Optional.of(GENERIC_EMPLOYEE_1));
		
		assertThrows(UsernameNotUniqueException.class,
			() -> authService.register(EMPLOYEE_TO_REGISTER)
		);

		verify(userService).getByUsername(EMPLOYEE_TO_REGISTER.getUsername());
		verify(userDAO, never()).create(EMPLOYEE_TO_REGISTER);
	}

	@Test
	public void testRegisterPassesWhenUsernameIsNotTaken() {
		when(userService.getByUsername(anyString())).thenReturn(Optional.empty());
//		when(userDAO.create(anyObject())).thenReturn(GENERIC_EMPLOYEE_1);
		
		assertEquals(GENERIC_EMPLOYEE_1, authService.register(EMPLOYEE_TO_REGISTER));

		verify(userService).getByUsername(EMPLOYEE_TO_REGISTER.getUsername());
		verify(userDAO).create(EMPLOYEE_TO_REGISTER);
	}

	@Test
	public void testRegisterFailsWhenRegistrationIsUnsuccessful() {
//		when(userDAO.create(anyObject())).thenThrow(new RegistrationUnsuccessfulException());

		assertThrows(RegistrationUnsuccessfulException.class,
				() -> authService.register(EMPLOYEE_TO_REGISTER)
		);
	}

	@Test
	public void testRegisterFailsWhenIdIsNonZero() {
		EMPLOYEE_TO_REGISTER.setId(1000);

		assertThrows(NewUserHasNonZeroIdException.class,
				() -> authService.register(EMPLOYEE_TO_REGISTER)
		);
	}

	@Test
	public void testLoginPassesWhenUsernameDoesExistAndPasswordMatches() {
		when(userService.getByUsername(anyString())).thenReturn(Optional.of(GENERIC_EMPLOYEE_1));

		assertEquals(GENERIC_EMPLOYEE_1, authService.login(GENERIC_EMPLOYEE_1.getUsername(), GENERIC_EMPLOYEE_1.getPassword()));

		verify(userService).getByUsername(EMPLOYEE_TO_REGISTER.getUsername());
	}
}
