package com.revature;


import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UsersController;
import com.revature.models.Menu;
import com.revature.util.ConnectionFactory;
import io.javalin.Javalin;

public class Driver {

    public static void main(String[] args) {
    	
    	UsersController uc = new UsersController();
    	ReimbursementController rc = new ReimbursementController();
    	AuthController ac = new AuthController();
    	
    	try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful :)");
		} catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		
	//	Menu menu = new Menu();
		
	//	menu.displayMenu();
	
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins();
				}
			).start(3000);
	
	app.get("/Users", uc.getUsersHandler);
	app.post("/Users", uc.insertUsersHandler);
	app.put("/Users", uc.updateUsersHandler);
	app.delete("/Users/{user_id}", uc.deleteUsersHandler);
	app.get("/Reimbursement", rc.getReimbursementHandler);
	app.get("/Reimbursement/{reibm_id}", rc.getReimbursementHandlerp);
	app.post("/Reimbursement", rc.insertReimbursementHandler);
	app.put("/Reimbursement", rc.updateReimbursementHandler);
	app.delete("/Reimbursement/{reibm_id}", rc.deleteReimbursementHandler);
	app.get("/Users/{user_id}", uc.getUsersHandler);
	app.put("/Users/{user_id}", uc.updateUsersHandler);
	app.post("/login", ac.loginHandler);

		}

}
   
