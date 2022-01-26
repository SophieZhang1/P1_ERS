package com.revature.models;


public class User_Role {
	
	public static String employee;
	public static String financemanager;
	private int user_role_id;
    private EnumUser_Role role;
        
    
    public User_Role() {
        super();
    }

    
    public User_Role(int user_role_id, EnumUser_Role role) {
        super();
        this.user_role_id = user_role_id;
        this.role = role;
    }
    
    
    
    @Override
    public String toString() {
        return "Role [user_role_id=" + user_role_id + ", role=" + role + "]";
    }

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    public EnumUser_Role getRole() {
        return role;
    }

    public void setRole(EnumUser_Role role) {
        this.role = role;
    }

   
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + user_role_id;
        result = prime * result + ((role == null) ? 0 : role.hashCode());
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
        User_Role other = (User_Role) obj;
        if (user_role_id != other.user_role_id)
            return false;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        return true;
    }

}




/**
 * Users within the ERS application are categorized within the following roles:
 * <ul>
 *     <li>Employee</li>
 *     <li>Finance Manager</li>
 * </ul>
 *
 * Employees are the standard role for Users within the application.
 *
 * Finance Managers have additional permissions to process reimbursement requests.
 * <ul>
 *     <li>Finance Managers can submit reimbursement requests</li>
 *     <li>Finance Managers cannot process their own requests</li>
 * </ul>
 *
 * @author Center of Excellence
 *
 */