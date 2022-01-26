package com.revature.repositories;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

     
public class ReimbursementDAO {

	public List<Reimbursement> getReimbursement() { 
		
		try(Connection conn = ConnectionFactory.getConnection()){ 
			
			ResultSet rs = null;
			
			String sql = "SELECT * FROM reimbursement;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<Reimbursement> ReimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				
				Reimbursement r = new Reimbursement(
						
						rs.getInt("reibm_id"),
						rs.getString("status"),
						rs.getString("reibm_submitted"),
						rs.getString("reibm_resolved"),
						rs.getString("reibm_description"),
						rs.getInt("reibm_receipt"),
						rs.getInt("author"),
						rs.getInt("resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("remib_type_id"),
						rs.getFloat("amount")
						);
				
				ReimbursementList.add(r); 
		
			}
						
			return ReimbursementList;
			
		} catch (SQLException r) {
			System.out.println("Something went wrong selecting reimbursement!");
			r.printStackTrace();
		}
		
		return null; 
		
	}
	
public List<Reimbursement> getReimbursementById(int reibm_id) { 
		
		try(Connection conn = ConnectionFactory.getConnection()){ 
			
			ResultSet rs = null;
			
			String sql = "select * from reimbursement where reibm_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reibm_id);
			
			rs = ps.executeQuery();
			
			List<Reimbursement> ReimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				
				Reimbursement r = new Reimbursement(
						
						rs.getInt("reibm_id"),
						rs.getString("status"),
						rs.getString("reibm_submitted"),
						rs.getString("reibm_resolved"),
						rs.getString("reibm_description"),
						rs.getInt("reibm_receipt"),
						rs.getInt("author"),
						rs.getInt("resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("remib_type_id"),
						rs.getFloat("amount")
						);
				
				ReimbursementList.add(r); 
		
			}
						
			return ReimbursementList;
			
		} catch (SQLException r) {
			System.out.println("Something went wrong selecting reimbursement!");
			r.printStackTrace();
		}
		
		return null; 
		
	}
	
	
public void insertReimbursement(Reimbursement newReimbursement) { 
	
	try(Connection conn = ConnectionFactory.getConnection()){
		
		String sql = "INSERT INTO reimbursement (status, reibm_submitted, reibm_resolved, reibm_description, reibm_receipt, author, resolver, reimb_status_id, remib_type_id, amount) " 
				    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?); "; 
		
		PreparedStatement ps = conn.prepareStatement(sql); 
		
		ps.setString(1, newReimbursement.getstatus());
		ps.setString(2, newReimbursement.getreibm_submitted());
		ps.setString(3, newReimbursement.getreibm_resolved());
		ps.setString(4, newReimbursement.getreibm_description());
		ps.setInt(5, newReimbursement.getreibm_receipt());
		ps.setInt(6, newReimbursement.getauthor());
		ps.setInt(7, newReimbursement.getresolver());
		ps.setInt(8, newReimbursement.getreimb_status_id());
		ps.setInt(9, newReimbursement.getremib_type_id());
		ps.setFloat(10, newReimbursement.getamount());
		ps.executeUpdate();  	
		
		
		System.out.println("reibm_id " + newReimbursement.getstatus());
	    			
	} catch(SQLException r) {
		System.out.println("Add reibm_id failed! :(");
		r.printStackTrace();
	}
	
}

	
	public void updateReimbursement(Reimbursement r) { 
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "UPDATE reimbursement set status = ?, reibm_submitted = ?, reibm_resolved = ?, reibm_description = ?, reibm_receipt = ?, author = ?, resolver = ?, reimb_status_id = ?, remib_type_id = ?, amount = ? where reibm_id = ?"; 
				    
			PreparedStatement ps = conn.prepareStatement(sql); 
			
			ps.setString(1, r.getstatus()); 
			ps.setString(2, r.getreibm_submitted());
			ps.setString(3, r.getreibm_resolved()); 
			ps.setString(4, r.getreibm_description()); 
			ps.setInt(5, r.getreibm_receipt()); 
			ps.setInt(6, r.getauthor());
			ps.setInt(7, r.getresolver());
			ps.setInt(8, r.getreimb_status_id()); 
			ps.setInt(9, r.getremib_type_id()); 
			ps.setFloat(10, r.getamount());
			ps.setInt(11, r.getreibm_id());
			ps.executeUpdate();  					
			
			System.out.println("reibm_id " + r.getstatus() + " updated successfully!");
		    			
		} catch(SQLException u1) {
			System.out.println("updated failed! :(");
			u1.printStackTrace();
		}
		
	}
	
	
	public boolean deleteReimbursement(int reibm_id) { 
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "delete from reimbursement where reibm_id = ?";
				    
			PreparedStatement ps = conn.prepareStatement(sql); 
			
			ps.setInt(1, reibm_id);
			
			ps.executeUpdate();  					
			
			System.out.println("Deleted successfully!");
		    			
		} catch(SQLException u1) {
			System.out.println("Deleted failed! :(");
			u1.printStackTrace();
			
		}
		return false;
		
	}

	public Object getById(int anyInt) {
		return null;
	}

	public Object update(Object any) {
		return null;
	}

	public Object getByStatus(Object any) {
		return null;
	}
}
		





/**
 * Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
 */

/**
 * Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.
 */
/**
 * <ul>
 *     <li>Should Update an existing Reimbursement record in the DB with the provided information.</li>
 *     <li>Should throw an exception if the update is unsuccessful.</li>
 *     <li>Should return a Reimbursement object with updated information.</li>
 * </ul>
 */
