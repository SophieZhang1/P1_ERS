package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class StatusDAO {

public void updateStatus(int reimb_status_id, String reimb_status) {
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "update reimb_status set reimb_status_id = ? where reimb_status = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimb_status_id);
			ps.setString(2, reimb_status);
			
			ps.executeUpdate();
			
			System.out.println(reimb_status_id + " reimb_status has been updated to: " + reimb_status);
			
		} catch (SQLException e) {
			System.out.println("Your status is not changed.");
			e.printStackTrace();
		}

	}
	
}