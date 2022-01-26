package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.revature.util.ConnectionFactory;

public class RoleDAO {

public void updateRole(int user_role_id, String role) {
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "update role set user_role_id = ? where role = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user_role_id);
			ps.setString(2, role);
			
			ps.executeUpdate();
			
			System.out.println(user_role_id + " role has been updated to: " + role);
			
		} catch (SQLException e) {
			System.out.println("You are not promoted.");
			e.printStackTrace();
		}

	}
	
}