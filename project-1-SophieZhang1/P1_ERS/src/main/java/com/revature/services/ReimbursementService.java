package com.revature.services;

import com.revature.models.Reimbursement;
import com.revature.models.Users;
import com.revature.repositories.ReimbursementDAO;
import java.util.List;


public class ReimbursementService {
	
	ReimbursementDAO rDAO = new ReimbursementDAO();
	
	   	public List<Reimbursement> getReimbursement() {
				
				List<Reimbursement> Reimbursement = rDAO.getReimbursement();
				
				return Reimbursement;
			}
			
	   	
	   	
			public void addReimbursement(Reimbursement newReimbursement) {
				
				rDAO.insertReimbursement(newReimbursement);
			}
			
			

		    public List<Reimbursement> getReimbursementById(int reibm_idInput) {
				
				List<Reimbursement> reimbursement = getReimbursementById(reibm_idInput);
				
				return reimbursement;
			}
			
		
		

			public void updateReimbursement(Reimbursement reimbursement) {
				
			  	rDAO.updateReimbursement(reimbursement);
								
			}
			
						
	        public boolean deleteReimbursement(int reibm_id) {
				
				return rDAO.deleteReimbursement(reibm_id);
				
			}
	        

			public Object process(Reimbursement rEIMBURSEMENT_TO_PROCESS, String approved,
					Users gENERIC_FINANCE_MANAGER_1) {
				return null;
			}

			public Object getReimbursementByStatus(String pending) {
				
				return null;
			}

			
			
}

		
			

       	

			
	

	




//public void updateStatus(int reibm_idInput, String statusInput) {
		
		//rDAO.updateSalary(reibm_idInput, statusInput);
		
	//}	

    /**
     * <ul>
     *     <li>Should ensure that the user is logged in as a Finance Manager</li>
     *     <li>Must throw exception if user is not logged in as a Finance Manager</li>
     *     <li>Should ensure that the reimbursement request exists</li>
     *     <li>Must throw exception if the reimbursement request is not found</li>
     *     <li>Should persist the updated reimbursement status with resolver information</li>
     *     <li>Must throw exception if persistence is unsuccessful</li>
     * </ul>
     *
     * Note: unprocessedReimbursement will have a status of PENDING, a non-zero ID and amount, and a non-null Author.
     * The Resolver should be null. Additional fields may be null.
     * After processing, the reimbursement will have its status changed to either APPROVED or DENIED.
     */
    //public Reimbursement process(Reimbursement unprocessedReimbursement, Status finalStatus, Users resolver) {
        //return null;
    

    /**
     * Should retrieve all reimbursements with the correct status.
     */
    //public List<Reimbursement> getReimbursementsByStatus(Status status) {
        //return Collections.emptyList();
    //}
//}


/**
 * The ReimbursementService should handle the submission, processing,
 * and retrieval of Reimbursements for the ERS application.
 *
 * {@code process} and {@code getReimbursementsByStatus} are the minimum methods required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create Reimbursement</li>
 *     <li>Update Reimbursement</li>
 *     <li>Get Reimbursements by ID</li>
 *     <li>Get Reimbursements by Author</li>
 *     <li>Get Reimbursements by Resolver</li>
 *     <li>Get All Reimbursements</li>
 * </ul>
 */


