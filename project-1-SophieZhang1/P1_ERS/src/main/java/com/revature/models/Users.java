package com.revature.models;


public class Users extends AbstractUsers {
	
	public Users() {
		super();
	}
	                     
    public Users(int user_id, String username, String password, String first_name, String last_name, String email, int user_role_id) {
	    super(user_id, username, password, first_name, last_name, email, user_role_id);
	  
		}    
	        
    	
 	public Users(String username, String password, String first_name, String last_name, String email, int user_role_id) {
 	    super();
 		  
 	    }
 	    
 	 	    
 	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", username=" + username + ", password=" + password + ", first_name" + first_name + ", last_name" + last_name + ", email" + email + ", user_role_id=" + user_role_id + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + user_id;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + user_role_id;
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
		Users other = (Users) obj;
		if (user_id != other.user_id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (user_role_id != other.user_role_id)
			return false;
		
		return true;
	}
	

	public void setId(int i) {
		
	}

	public static void remove(int getuser_id) {
		
	}
}



/**
 * This concrete User class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>First Name</li>
 *     <li>Last Name</li>
 *     <li>Email</li>
 *     <li>Phone Number</li>
 *     <li>Address</li>
 * </ul>
 *
 */
/**
 * This includes the minimum parameters needed for the {@link com.revature.models.AbstractUsers} class.
 * If other fields are needed, please create additional constructors.
 */
