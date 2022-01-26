package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Users;
import com.revature.util.ConnectionFactory;


	public class UsersDAO {

    	public List<Users> getUsers() { 
    		
    		try(Connection conn = ConnectionFactory.getConnection()){ 
    			
    			ResultSet rs = null;
    			
    			String sql = "SELECT * FROM users;";
    			
    			PreparedStatement ps = conn.prepareStatement(sql);
    			rs = ps.executeQuery();
    			
    			List<Users> UsersList = new ArrayList<>();
    			
    			while(rs.next()) {
    				
    				Users u = new Users(
    						
    						rs.getInt("user_id"),
    						rs.getString("username"),
    						rs.getString("password"),
    						rs.getString("first_name"),
    						rs.getString("last_name"),
    						rs.getString("email"),
    						rs.getInt("user_role_id")
    						);
    				
    				UsersList.add(u); 
    		
    			}
    						
    			return UsersList;
    			
    		} catch (SQLException u) {
    			System.out.println("Something went wrong selecting users!");
    			u.printStackTrace();
    		}
    		
    		return null; 
    		
    	}
    	
    	public void insertUsers(Users newUsers) { 
    		
    		try(Connection conn = ConnectionFactory.getConnection()){
    			
    			String sql = "INSERT INTO users (username, password, first_name, last_name, email, user_role_id) " 
    					    + "VALUES (?, ?, ?, ?, ?, ?); "; 
    			
    			PreparedStatement ps = conn.prepareStatement(sql); 
    			
    			ps.setString(1, newUsers.getUsername()); 
    			ps.setString(2, newUsers.getPassword());
    			ps.setString(3, newUsers.getFirst_name()); 
    			ps.setString(4, newUsers.getLast_name()); 
    			ps.setString(5, newUsers.getEmail()); 
    			ps.setInt(6, newUsers.getuser_role_id());
    			ps.executeUpdate();  			
    			
    			System.out.println("User " + newUsers.getUsername() + " created. Welcome aboard!");
    		    			
    		} catch(SQLException u) {
    			System.out.println("Add employee failed! :(");
    			u.printStackTrace();
    		}
    		
    	}
    	
    	
    	public void updateUsers(Users u) { 
    		
    		try(Connection conn = ConnectionFactory.getConnection()){
    			
    			String sql = "UPDATE users set username = ?, password = ?, first_name = ?, last_name = ?, email = ?, user_role_id = ? where user_id = ?"; 
					    
    			PreparedStatement ps = conn.prepareStatement(sql); 
    			
    			ps.setString(1, u.getUsername()); 
    			ps.setString(2, u.getPassword());
    			ps.setString(3, u.getFirst_name()); 
    			ps.setString(4, u.getLast_name()); 
    			ps.setString(5, u.getEmail()); 
    			ps.setInt(6, u.getuser_role_id());
    			ps.setInt(7, u.getuser_id()); 
    			ps.executeUpdate();  					
    			
    			System.out.println("User " + u.getUsername() + " updated successfully!");
    		    			
    		} catch(SQLException u1) {
    			System.out.println("updated failed! :(");
    			u1.printStackTrace();
    		}
    		
    	}
    	
    	
         public boolean deleteUsers(int user_id) { 
    		
    		try(Connection conn = ConnectionFactory.getConnection()){
    			
    			String sql = "delete from users where user_id = ?";
					    
    			PreparedStatement ps = conn.prepareStatement(sql); 
    			
    			ps.setInt(1, user_id);
    			
    			ps.executeUpdate();  					
    			
    			System.out.println("Deleted successfully!");
    		    			
    		} catch(SQLException u1) {
    			System.out.println("deleted failed! :(");
    			u1.printStackTrace();
    			
    		}
			return false;
    		
    	}
    	
    	
         	
    	public static List<Users> getUsersByusername(String usernameInput) {
			return null;
		}
    	
    	
    public List<Users> getUsersByRole(String role) {
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from users inner join user_role "
					     + "on users.user_role_id = user_role.role_id where user_role.role = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, role);
			
			rs = ps.executeQuery();	
			
			List<Users> UsersList = new ArrayList<>();
			
			while(rs.next()) {
				
				Users u = new Users(
						rs.getString("Username"),
						rs.getString("Password"),
						rs.getString("First_name"),
						rs.getString("Last_name"),
						rs.getString("email"),
						rs.getInt("user_role_id")
						);
				
				UsersList.add(u); 
			}
			
			return UsersList; 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public Object getByUsername(String anyString) {
		return null;
	}

	public void create(Users eMPLOYEE_TO_REGISTER) {
		
	}
	
	
}
	
	
	
	
	
	/**
     * Should retrieve a User from the DB with the corresponding username or an empty optional if there is no match.
     */
    /**
     * <ul>
     *     <li>Should Insert a new User record into the DB with the provided information.</li>
     *     <li>Should throw an exception if the creation is unsuccessful.</li>
     *     <li>Should return a User object with an updated ID.</li>
     * </ul>
     *
     * Note: The userToBeRegistered will have an id=0, and username and password will not be null.
     * Additional fields may be null.
     */