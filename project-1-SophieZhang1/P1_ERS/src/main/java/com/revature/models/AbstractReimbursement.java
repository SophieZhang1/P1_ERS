package com.revature.models;

import java.util.Objects;


public class AbstractReimbursement {

	protected int reibm_id;
    protected String status;
    protected String reibm_submitted;
	protected String reibm_resolved;
	protected String reibm_description;
	protected int reibm_receipt;  
    protected int author;
    protected int resolver;
    protected int reimb_status_id;
    protected int remib_type_id; 
    protected float amount;

    public AbstractReimbursement() {
        super();
    }

    public AbstractReimbursement(int reibm_id, String status, String reibm_submitted, String reibm_resolved, String reibm_description, int reibm_receipt, int author, int resolver, int reimb_status_id, int remib_type_id, float amount) {
        super();
        this.reibm_id = reibm_id;
        this.status = status;
        this.reibm_submitted = reibm_submitted;
    	this.reibm_resolved = reibm_resolved;
    	this.reibm_description = reibm_description;
    	this.reibm_receipt = reibm_receipt;  
        this.author = author;
        this.resolver = resolver;
        this.reimb_status_id = reimb_status_id;
        this.remib_type_id = remib_type_id; 
        this.amount = amount;
    }

    public int getreibm_id() {
		return reibm_id;
	}

	public void setreibm_id(int reibm_id) {
		this.reibm_id = reibm_id;
	}

	public String getstatus() {
		return status;
	}

	public void setstatus(String status) {
		this.status = status;
	}
	
	public String getreibm_submitted() {
		return reibm_submitted;
	}

	public void setreibm_submitted(String reibm_submitted) {
		this.reibm_submitted = reibm_submitted;
	}
	
	public String getreibm_resolved() {
		return reibm_resolved;
	}

	public void setreibm_resolved(String reibm_resolved) {
		this.reibm_resolved = reibm_resolved;
	}
	
	public String getreibm_description() {
		return reibm_description;
	}

	public void setdescription(String reibm_description) {
		this.reibm_description = reibm_description;
	}
	
	public int getreibm_receipt() {
		return reibm_id;
	}

	public void setreibm_receipt(int reibm_receipt) {
		this.reibm_receipt = reibm_receipt;
	}

	public int getauthor() {
		return author;
	}

	public void setauthor(int author) {
		this.author = author;
	}

	public int getresolver() {
		return resolver;
	}
	

	public void setresolver(int resolver) {
		this.resolver = resolver;
	}
	
	public int getreimb_status_id() {
		return reimb_status_id;
	}

	public void setreimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}
	
	public int getremib_type_id() {
		return remib_type_id;
	}

	public void setremib_type_id(int remib_type_id) {
		this.remib_type_id = remib_type_id;
	}
	
	public float getamount() {
		return amount;
	}
	

	public void setamount(float amount) {
		this.amount = amount;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractReimbursement that = (AbstractReimbursement) o;
        return reibm_id == that.reibm_id && Objects.equals(status, that.status) && Objects.equals(reibm_submitted, that.reibm_submitted) && Objects.equals(reibm_resolved, that.reibm_resolved) && Objects.equals(reibm_description, that.reibm_description) && reibm_receipt == that.reibm_receipt && author == that.author && resolver == that.resolver && reimb_status_id == that.reimb_status_id && remib_type_id == that.remib_type_id && amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reibm_id, status, reibm_submitted, reibm_resolved, reibm_description, reibm_receipt, author, resolver, reimb_status_id, remib_type_id, amount);
    }

    @Override
    public String toString() {
        return "AbstractReimbursement{" +
                "reibm_id=" + reibm_id +
                ", status=" + status +
                ", reibm_submitted=" + reibm_submitted +
                ", reibm_resolved=" + reibm_resolved +
                ", reibm_description=" + reibm_description +
                ", reibm_receipt=" + reibm_receipt +
                ", author=" + author +
                ", resolver=" + resolver +
                ", reimb_status_id=" + reimb_status_id +
                ", remib_type_id=" + remib_type_id +
                ", amount=" + amount +
                '}';
    }
}





/**
 * This AbstractReimbursement class defines a minimum functionality for
 * interacting with reimbursements in the ERS application.
 *
 * All reimbursements in this application must at least have:
 * <ul>
 *     <li>ID</li>
 *     <li>Status</li>
 *     <li>Author</li>
 *     <li>Resolver</li>
 *     <li>Amount</li>
 * </ul>
 *
 * Additional fields can be added to the concrete {@link com.revature.models.Reimbursement} class.
 *
 * @author Center of Excellence
 */
