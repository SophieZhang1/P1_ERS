package com.revature.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.User_Role;
import com.revature.models.Users;
import com.revature.repositories.ReimbursementDAO;

public class ReimbursementServiceTest {

	private static ReimbursementService reimbursementService;
	private static ReimbursementDAO reimbursementDAO;
	
	private Reimbursement REIMBURSEMENT_TO_PROCESS;
	private Reimbursement GENERIC_REIMBURSEMENT_1;
	private Reimbursement GENERIC_REIMBURSEMENT_2;
	private List<Reimbursement> GENERIC_ALL_PENDING_REIMBURSEMENTS;
	private Users GENERIC_FINANCE_MANAGER_1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reimbursementService = new ReimbursementService();
		reimbursementDAO = mock(ReimbursementDAO.class);
	}
	
	@Before
	public void setUp() throws Exception {
		new Users(1, "genericEmployee1", "genericPassword", User_Role.employee, null, null, 0);
		GENERIC_FINANCE_MANAGER_1 = new Users(1, "genericManager1", "genericPassword", User_Role.financemanager, null, null, 0);
		
		REIMBURSEMENT_TO_PROCESS = new Reimbursement();
		GENERIC_REIMBURSEMENT_1 = new Reimbursement();
		GENERIC_REIMBURSEMENT_2 = new Reimbursement();
		
		GENERIC_ALL_PENDING_REIMBURSEMENTS = new ArrayList<Reimbursement>();
		GENERIC_ALL_PENDING_REIMBURSEMENTS.add(GENERIC_REIMBURSEMENT_1);
	}
	
	@Test
	public void testProcessPassesWhenUserIsFinanceManagerAndReimbursementExistsAndUpdateSuccessful() {
		when(reimbursementDAO.getById(anyInt())).thenReturn(Optional.of(GENERIC_REIMBURSEMENT_1));
		when(reimbursementDAO.update(any())).thenReturn(GENERIC_REIMBURSEMENT_2);
		
		assertEquals(GENERIC_REIMBURSEMENT_2, reimbursementService.process(REIMBURSEMENT_TO_PROCESS, Status.APPROVED, GENERIC_FINANCE_MANAGER_1));
		
		verify(reimbursementDAO).getById(REIMBURSEMENT_TO_PROCESS.getId());
		verify(reimbursementDAO).update(REIMBURSEMENT_TO_PROCESS);
	}
	
	@Test
	public void testGetReimbursementByStatusPassesWhenReimbursementsAreSuccessfullyReturned() {
		when(reimbursementDAO.getByStatus(any())).thenReturn(GENERIC_ALL_PENDING_REIMBURSEMENTS);
		
		assertEquals(GENERIC_ALL_PENDING_REIMBURSEMENTS, reimbursementService.getReimbursementByStatus(Status.PENDING));
		
		verify(reimbursementDAO).getByStatus(Status.PENDING);
	}
}
