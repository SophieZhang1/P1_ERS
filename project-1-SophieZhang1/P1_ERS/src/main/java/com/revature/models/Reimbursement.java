package com.revature.models;


public class Reimbursement extends AbstractReimbursement {

	public Reimbursement() {
		super();
	}
	                     
       	
	public Reimbursement(int reibm_id, String status, String reibm_submitted, String reibm_resolved, String reibm_description, int reibm_receipt, int author, int resolver, int reimb_status_id, int remib_type_id, float amount) {
	    super(reibm_id, status, reibm_submitted, reibm_resolved, reibm_description, reibm_receipt, author, resolver, reimb_status_id, remib_type_id, amount);
	  
		}    
	        
    	
 	public Reimbursement(String status, String reibm_submitted, String reibm_resolved, String reibm_description, int reibm_receipt, int author, int resolver, int reimb_status_id, int remib_type_id, float amount) {
 	    super();
 		  
 	    }

	@Override
	public String toString() {
		return "Reimbursement [reibm_id=" + reibm_id + ", status=" + status + ", reibm_submitted=" + reibm_submitted + ", reibm_resolved=" + reibm_resolved + ", reibm_description=" + reibm_description + ", reibm_receipt=" + reibm_receipt + ", author=" + author + ", resolver=" + resolver + ", reimb_status_id=" + reimb_status_id + ", remib_type_id=" + remib_type_id + ", amount" + amount + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + reibm_id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((reibm_submitted == null) ? 0 : reibm_submitted.hashCode());
		result = prime * result + ((reibm_resolved == null) ? 0 : reibm_resolved.hashCode());
		result = prime * result + ((reibm_description == null) ? 0 : reibm_description.hashCode());
		result = prime * result + reibm_receipt;
		result = prime * result + author;
		result = prime * result + resolver;
		result = prime * result + reimb_status_id;
		result = prime * result + remib_type_id;
		result = prime * result + (int)amount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (reibm_id != other.reibm_id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (reibm_submitted == null) {
			if (other.reibm_submitted != null)
				return false;
		} else if (!reibm_submitted.equals(other.reibm_submitted))
			return false;
		if (reibm_resolved == null) {
			if (other.reibm_resolved != null)
				return false;
		} else if (!reibm_resolved.equals(other.reibm_resolved))
			return false;
		if (reibm_description == null) {
			if (other.reibm_description != null)
				return false;
		} else if (!reibm_description.equals(other.reibm_description))
			return false;
		if (reibm_receipt != other.reibm_receipt)
			return false;
		if (author != other.author)
			return false;
		if (resolver != other.resolver)
			return false;
		if (reimb_status_id != other.reimb_status_id)
			return false;
		if (remib_type_id != other.remib_type_id)
			return false;
		if (amount != other.amount)
			return false;
		return true;
	}

	public int getId() {
		return 0;
	}
}




/**
 * This concrete Reimbursement class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>Description</li>
 *     <li>Creation Date</li>
 *     <li>Resolution Date</li>
 *     <li>Receipt Image</li>
 * </ul>
 *
 */
