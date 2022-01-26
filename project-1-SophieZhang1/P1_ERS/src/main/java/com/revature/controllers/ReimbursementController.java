package com.revature.controllers;

	import java.util.List;
	import com.google.gson.Gson;
    import com.revature.models.Reimbursement;
    import com.revature.services.ReimbursementService;
    import io.javalin.http.Handler;

	public class ReimbursementController {
		
		ReimbursementService rs = new ReimbursementService();

		public Handler getReimbursementHandler = (ctx) -> {
			if(ctx.req.getSession() != null) { 
				
				List<Reimbursement> allReimbursement = rs.getReimbursement();
				
				Gson gson = new Gson();
				
				String JSONReimbursement = gson.toJson(allReimbursement);
				
				ctx.result(JSONReimbursement);
				ctx.status(200);
				

			} else {
				ctx.result("Oh no you failed to get the reimbursement!!!!");
				ctx.status(401);
			}
		};
		
		public Handler insertReimbursementHandler = (ctx) -> {
			
			if(ctx.req.getSession() != null) {
				String body = ctx.body();
				
				Gson gson = new Gson();
				
				Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
				
				rs.addReimbursement(reimbursement);
				
				ctx.result("Reimbursement was successfully added!");
				ctx.status(201);
				
			} else {
				ctx.result("Oh no you failed to insert a reimbursement!!!!");
				ctx.status(404);
			}
			
			
		};

		public Handler getReimbursementHandlerp = (ctx) -> {
	         if(ctx.req.getSession() != null) {
	             int reibm_id = Integer.parseInt(ctx.pathParam("reibm_id"));
	             Reimbursement Reimbursementp = (Reimbursement) rs.getReimbursementById(reibm_id);
	             Gson gson = new Gson();
	             String JSONReimbursement = gson.toJson(Reimbursementp);
	             ctx.result(JSONReimbursement);
	             ctx.status(200);
	         }else {
	             ctx.result("oh no you failed to get the Reimbursement!!");
	             ctx.status(404);
	         }
	     };
	     
	     public Handler updateReimbursementHandler = (ctx) -> {
	         if(ctx.req.getSession() != null) {
	           	 String body = ctx.body();
	             Gson gson = new Gson();
	             Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
	             rs.updateReimbursement(reimbursement);
	             ctx.result("you update the reimbursement!!");
	             ctx.status(200);

	         }else {
	             ctx.result("oh no you failed to update the reimbursement!! ");
	             ctx.status(404);
	         }

	     };
	     
	     public Handler deleteReimbursementHandler = (ctx) -> {
	         if(ctx.req.getSession() != null) {
	             int reibm_id = Integer.parseInt(ctx.pathParam("reibm_id"));
	             Boolean dreimbursementp = rs.deleteReimbursement(reibm_id);
	          
	             ctx.result("oh you Delete the user!!");
	             ctx.status(204);

	         }else {
	             ctx.result("oh no you failed to delete the user!! ");
	             ctx.status(404);
	         }

	     };

	 }
	 
	 

