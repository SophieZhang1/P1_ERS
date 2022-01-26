package com.revature.models;


public class Status {

    public static final String APPROVED = null;
	public static final String PENDING = null;
	private int reimb_status_id;
    private EnumStatus reimb_status;
        
    public Status() {
        super();
    }

    
    public Status(int reimb_status_id, EnumStatus reimb_status) {
        super();
        this.reimb_status_id = reimb_status_id;
        this.reimb_status = reimb_status;
    }

        
    @Override
    public String toString() {
        return "Status [reimb_status_id=" + reimb_status_id + ", reimb_status=" + reimb_status + "]";
    }

    public int getReimb_status_id() {
        return reimb_status_id;
    }

    public void setReimb_status_id(int reimb_status_id) {
        this.reimb_status_id = reimb_status_id;
    }

    public EnumStatus getReimb_status() {
        return reimb_status;
    }

    public void setReimb_status(EnumStatus Reimb_status, EnumStatus reimb_status) {
        this.reimb_status = reimb_status;
    }
    
       
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + reimb_status_id;
        result = prime * result + ((reimb_status == null) ? 0 : reimb_status.hashCode());
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
        Status other = (Status) obj;
        if (reimb_status_id != other.reimb_status_id)
            return false;
        if (reimb_status == null) {
            if (other.reimb_status != null)
                return false;
        } else if (!reimb_status.equals(other.reimb_status))
            return false;
        return true;
    }
}




/**
 * Reimbursements within the ERS application transition through the following statuses:
 * <ul>
 *     <li>Pending</li>
 *     <li>Approved</li>
 *     <li>Denied</li>
 * </ul>
 *
 * Once reimbursements are processed, their final status cannot be changed.
 * A new reimbursement must be submitted.
 *
 * @author Center of Excellence
 */
