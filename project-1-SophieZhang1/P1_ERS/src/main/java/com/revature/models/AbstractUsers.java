package com.revature.models;

import java.util.Objects;


public class AbstractUsers {

	protected int user_id;
	protected String username;
	protected String password;
	protected String first_name;
	protected String last_name;
	protected String email;
	protected int user_role_id;
	
    public AbstractUsers() {
        super();
    }

    public AbstractUsers(int user_id, String username, String password, String first_name, String last_name, String email, int user_role_id) {
        super();
        this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.user_role_id = user_role_id;
		    }

    public AbstractUsers(String username, String password, String first_name, String last_name, String email, int user_role_id) {
		super();
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.user_role_id = user_role_id;
	}

	public int getuser_id() {
        return user_id;
    }

    public void setuser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getuser_role_id() {
        return user_role_id;
    }

    public void setuser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

	public int hashCode1() {
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

	public boolean equals1(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractUsers other = (AbstractUsers) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_role_id != other.user_role_id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
    
        
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractUsers that = (AbstractUsers) o;
        return user_id == that.user_id && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(first_name, that.first_name) && Objects.equals(last_name, that.last_name) && Objects.equals(email, that.email) && user_role_id == that.user_role_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, username, password, first_name, last_name, email, user_role_id);
    }

    @Override
    public String toString() {
        return "AbstractUser{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", user_role_id" + user_role_id +
                '}';
    }
}






/**
 * This AbstractUser class defines a minimum functionality for
 * interacting with users in the ERS application.
 *
 * All users in this application must at least have:
 * <ul>
 *     <li>ID</li>
 *     <li>Username</li>
 *     <li>Password</li>
 *     <li>Role</li>
 * </ul>
 *
 * Additional fields can be added to the concrete {@link com.revature.models.Users} class.
 *
 * @author Center of Excellence
 */

