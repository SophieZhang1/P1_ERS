package com.revature.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.models.Users;

public class AuthService {

	public boolean login(String username, String password) {
		
		if(username.equals("user") && password.equals("password")) {
			
			return true; 
			
		}
		
		return false;
			
	}  
	
		

	public Object register(Users eMPLOYEE_TO_REGISTER) {
		return null;

	}
	
	
}	
	
	
	
	/*
	
		if(session.getAttribute("admin_login")!=null){
			response.sendRedirect("admin/admin_home.jsp");
		}

		if(session.getAttribute("employee_login")!=null){
	    	response.sendRedirect("employee/employee_home.jsp");
		}
		
				
	    if(request.getParameter("btn_login")!=null) 
	    {
	        String username,password,role;
	        
	        username=request.getParameter("txt_username"); 
	        password=request.getParameter("txt_password"); 
	        role=request.getParameter("txt_role"); 
	        
	        String dburl="jdbc:mysql://localhost:3306/jsp_multiuser_login_db"; //database url string the "jsp_multiuser_login_db" is database name
	        String dbuname="root"; //database username   
	        String dbpwd =""; //database password
	        
	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver"); //load driver
	            Connection con=DriverManager.getConnection(dburl,dbuname,dbpwd); //create connection
	            
	            PreparedStatement pstmt=null; //create statement
	            
	            pstmt=con.prepareStatement("SELECT * FROM tbl_user WHERE email=? AND password=? AND role=? "); //sql select query
	            pstmt.setString(1,username);
	            pstmt.setString(2,password);   
	            pstmt.setString(3,role);
	            ResultSet rs=pstmt.executeQuery(); 
	            
	            if(rs.next())
	            {
	                String dbemail=rs.getString("username");
	                String dbpassword=rs.getString("password");     
	                String dbrole=rs.getString("role");
	                
	                if(username.equals(user) && password.equals(password) && role.equals(role)) 
	                {
	                    if(role.equals("admin")) 
	                    {
	                        session.setAttribute("admin_login",dbemail); 
	                        response.sendRedirect("admin/admin_home.jsp"); 
	                    }
	                    else if(role.equals("employee")) 
	                    {
	                        session.setAttribute("employee_login",dbemail); 
	                        response.sendRedirect("employee/employee_home.jsp"); 
	                    }
	                 }
	            }
	            else
	            {
	                request.setAttribute("errorMsg","invalid username or password or role"); 
	            }
	            
	            pstmt.close(); 
	            con.close(); 
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	
	    
	    
	    if(request.getParameter("btn_register")!=null)  //check condition button register click event not null "btn_register"
	    {
	        String firstname,lastname,email,password,role; //create blank bariable
	        
	        firstname=request.getParameter("txt_firstname");	//textbox name "txt_fristname"
	        lastname=request.getParameter("txt_lastname");	//textbox name "txt_lastname"
	        email=request.getParameter("txt_email");	//textbox name "txt_email"
	        password=request.getParameter("txt_password");	//textbox name "txt_password"
	        role=request.getParameter("txt_role"); //select option name "txt_role"
	        
	        String dburl="jdbc:mysql://localhost:3306/jsp_multiuser_login_db"; //database url string the "jsp_multiuser_login_db" is database name
	        String dbuname="root"; //database username   
	        String dbpwd =""; //database password
	        
	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver"); //load driver
	            Connection con=DriverManager.getConnection(dburl,dbuname,dbpwd); //create connection
	            
	            PreparedStatement pstmt=null; //create statement
	            
	            pstmt=con.prepareStatement("SELECT * FROM tbl_user WHERE email=? "); //sql select query
	            pstmt.setString(1,email); 
	            ResultSet rs=pstmt.executeQuery(); //execute query and set in ResultSet object "rs".
	           
	            if(rs.next())
	            {
	                String checkEmail=rs.getString("email");
	                
	                if(email.equals(checkEmail))    //check condition email already exist from user email
	                {
	                    request.setAttribute("errorMsg", "sorry email already exist"); //error message for email already exist
	                }
	            }
	            else
	            {
	                pstmt=con.prepareStatement("INSERT INTO tbl_user(firstname,lastname,email,password,role) VALUES(?,?,?,?,?)"); //sql insert query
	                pstmt.setString(1,firstname);
	                pstmt.setString(2,lastname);
	                pstmt.setString(3,email);           //set all variables
	                pstmt.setString(4,password);
	                pstmt.setString(5,role);
	                pstmt.executeUpdate(); //execute query
	                
	                request.setAttribute("successMsg", "register successfully please login account"); //register successfully message
	            }
	            
	            pstmt.close();  //close statement 
	            con.close(); //close connection
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }

	
	*/
	








/*   * The AuthService should handle login and registration for the ERS application.
*
* {@code login} and {@code register} are the minimum methods required; however, additional methods can be added.
*
* Examples:
* <ul>
*     <li>Retrieve Currently Logged-in User</li>
*     <li>Change Password</li>
*     <li>Logout</li>
* </ul>

 * 
 *  
    * <ul>
    *     <li>Needs to check for existing users with username/email provided.</li>
    *     <li>Must throw exception if user does not exist.</li>
    *     <li>Must compare password provided and stored password for that user.</li>
    *     <li>Should throw exception if the passwords do not match.</li>
    *     <li>Must return user object if the user logs in successfully.</li>
    * </ul>
    *  /* * This is an example method signature for retrieving the currently logged-in user.
     * It leverages the Optional type which is a useful interface to handle the
     * possibility of a user being unavailable.
     * 
     *  <ul>
     *     <li>Should ensure that the username/email provided is unique.</li>
     *     <li>Must throw exception if the username/email is not unique.</li>
     *     <li>Should persist the user object upon successful registration.</li>
     *     <li>Must throw exception if registration is unsuccessful.</li>
     *     <li>Must return user object if the user registers successfully.</li>
     *     <li>Must throw exception if provided user has a non-zero ID</li>
     * </ul>
     *
     * Note: userToBeRegistered will have an id=0, additional fields may be null.
     * After registration, the id will be a positive integer.
     * 
     * /* * This is an example method signature for retrieving the currently logged-in user.
     * It leverages the Optional type which is a useful interface to handle the
     * possibility of a user being unavailable.*/
    


