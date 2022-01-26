package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class TypeDAO {

public void updateType(int remib_type_id, String remib_type) {
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "update remib_type set remib_type_id = ? where remib_type = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, remib_type_id);
			ps.setString(2, remib_type);
			
			ps.executeUpdate();
			
			System.out.println(remib_type_id + " remib_type has been updated to: " + remib_type);
			
		} catch (SQLException e) {
			System.out.println("Type is not changed.");
			e.printStackTrace();
		}

	}
	
}