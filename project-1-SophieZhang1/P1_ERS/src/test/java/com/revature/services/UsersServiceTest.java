package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import java.util.Optional;
import com.revature.repositories.UsersDAO;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.revature.models.Users;


public class UsersServiceTest {

    private static UsersService userService;
    private static UsersDAO userDAO;

    private Users GENERIC_EMPLOYEE_1;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        userService = new UsersService();
        userDAO = mock(UsersDAO.class);
    }

    @Before
    public void setUp() throws Exception {
        GENERIC_EMPLOYEE_1 = new Users();
    }

    @Test
    public void testGetByUsernamePassesWhenUsernameExists() {
        when(userDAO.getByUsername(anyString())).thenReturn(Optional.of(GENERIC_EMPLOYEE_1));

        assertEquals(Optional.of(GENERIC_EMPLOYEE_1), userService.getByUsername(GENERIC_EMPLOYEE_1.getUsername()));

        verify(userDAO).getByUsername(GENERIC_EMPLOYEE_1.getUsername());
    }
}









