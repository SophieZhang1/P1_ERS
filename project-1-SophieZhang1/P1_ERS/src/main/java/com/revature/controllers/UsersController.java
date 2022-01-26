package com.revature.controllers;

import java.util.List;
import com.google.gson.Gson;
import com.revature.models.Users;
import com.revature.services.UsersService;
import io.javalin.http.Handler;

public class UsersController {
	
	UsersService usr = new UsersService();

	public Handler getUsersHandler = (ctx) -> {
		if(ctx.req.getSession() != null) { 
			
			List<Users> allUsers = usr.getUsers();
			
			Gson gson = new Gson();
			
			String JSONUsers = gson.toJson(allUsers);
			
			ctx.result(JSONUsers);
			ctx.status(200);
			

		} else {
			ctx.result("Oh no you failed to get the users!!!!");
			ctx.status(404);
		}
	};
	
	public Handler insertUsersHandler = (ctx) -> {
		
		if(ctx.req.getSession() != null) {
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			Users users = gson.fromJson(body, Users.class);
			
			usr.addUsers(users);
			
			ctx.result("Users was successfully added!");
			ctx.status(201);
			
		} else {
			ctx.result("Oh no you failed to insert a user!!!!");
			ctx.status(404);
		}
		
		
	};
    
	 public Handler getUsersHandlerp = (ctx) -> {
         if(ctx.req.getSession() != null) {
             int user_id = Integer.parseInt(ctx.pathParam("user_id")) ;
             Users Usersp = (Users) usr.getUsersByuser_id(user_id);
             Gson gson = new Gson();
             String JSONUsers = gson.toJson(Usersp);
             ctx.result(JSONUsers);
             ctx.status(200);
         }else {
             ctx.result("oh no you failed to get the users!! ");
             ctx.status(404);
         }
     };
     
     public Handler updateUsersHandler = (ctx) -> {
         if(ctx.req.getSession() != null) {
           	 String body = ctx.body();
             Gson gson = new Gson();
             Users users = gson.fromJson(body, Users.class);
             usr.updateUsers(users);
             ctx.result("oh you update the user!!");
             ctx.status(200);

         }else {
             ctx.result("oh no you failed to update the user!! ");
             ctx.status(404);
         }

     };
     
     public Handler deleteUsersHandler = (ctx) -> {
         if(ctx.req.getSession() != null) {
             int user_id = Integer.parseInt(ctx.pathParam("user_id"));
             Boolean duserp = usr.deleteUsers(user_id);
            
             ctx.result("oh you Delete the user!!");
             ctx.status(204);

         }else {
             ctx.result("oh no you failed to delete the user!! ");
             ctx.status(404);
         }

     };

	   
 }
 
 
