package com.revature.models;

import java.util.List;
import java.util.Scanner;
import com.revature.repositories.UsersDAO;
import com.revature.services.UsersService;
import java.util.List;
import java.util.Scanner;
import com.revature.services.ReimbursementService;


@SuppressWarnings("unused")
public class Menu {

	UsersService usr = new UsersService();
	ReimbursementService rbs = new ReimbursementService();
		
	public void displayMenu() {
		
		boolean displayMenu = true;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		System.out.println("Welcome to The Employee Reimbursment Management System");
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		
		
		while(displayMenu) { 
			
			System.out.println("hi -> get greeted");
			System.out.println("users -> show all users");
			System.out.println("usersById -> get users with a certain ID");
			System.out.println("usersByUser_Role -> get employees of a certain role");
			System.out.println("add -> add a new user");
			System.out.println("exit -> exit the application");
			
			
			String input = scan.nextLine();
			
			switch(input) {
			
			case "hi": {
				System.out.println("Hello!");
				break;
			}
			
			case "users" :{
				
				List<Users> users = usr.getUsers();
				
				for (Users u : users) {
					System.out.println(u);
				}
				
				break;
			}
			
             case "reimbursement" :{
				
				List<Reimbursement> reimbursement = rbs.getReimbursement();
				
				for (Reimbursement r : reimbursement) {
					System.out.println(r);
				}
				
				break;
			}
			
			case "usersById" :{
				System.out.println("What userID would you like to search for?");
				
				int user_idInput = scan.nextInt();
				scan.nextLine();
				
				List<Users> users = usr.getUsersByuser_id(user_idInput);
				
				for(Users user : users) {
					System.out.println(user);
				}
				
				break;
			}
			
			case "reimbursementById" :{
				System.out.println("What reimbursementID would you like to search for?");
				
				int reibm_idInput = scan.nextInt();
				scan.nextLine();
				
				List<Reimbursement> reimbursement = rbs.getReimbursementById(reibm_idInput);
				
				for(Reimbursement r : reimbursement) {
					System.out.println(r);
				}
				
				break;
			}
			
			case "userbyrole": {
				
			System.out.println("Enter User Role to Search)");
			String roleInput = scan.nextLine();
			
			List<Users> users = usr.getUsersByRole(roleInput);
			
			for(Users u : users)
			{
				System.out.println(u);
			}
			break;				
			
		}
			
			case "addUsers" : {
				
				System.out.println("Enter Username");
				String username = scan.nextLine();
				
				System.out.println("Enter password");
				String password = scan.nextLine();
				
				System.out.println("Enter User First Name");
				String first_name = scan.nextLine();
				
				System.out.println("Enter User Last Name");
				String last_name = scan.nextLine();
				
				System.out.println("Enter User email");
				String email = scan.nextLine();
				
				System.out.println("Enter Role Id: 1) Employee 2) Finance Manager");
				int user_role_id = scan.nextInt();
								
				System.out.println("Enter User reibm_id");
				int reibm_id = scan.nextInt();
				scan.nextLine();
				
				Users newUsers = new Users(username, password, first_name, last_name, email, user_role_id);
				
				usr.addUsers(newUsers);
				
				break;
			}
			
            case "addReimbursement" : {
				
				System.out.println("Enter status");
				String status = scan.nextLine();
				
				System.out.println("Enter reibm_submitted");
				String reibm_submitted = scan.nextLine();
				
				System.out.println("Enter reibm_resolved");
				String reibm_resolved = scan.nextLine();
				
				System.out.println("Enter reibm_description");
				String reibm_description = scan.nextLine();
				
				System.out.println("Enter reibm_receipt");
				String reibm_receipt = scan.nextLine();
				
				System.out.println("Enter author");
				int author = scan.nextInt();
								
				System.out.println("Enter resolver");
				int resolver = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Enter reimb_status_id");
				int reimb_status_id = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Enter remib_type_id");
				int remib_type_id = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Enter amount");
				int amount = scan.nextInt();
				scan.nextLine();
				
				Reimbursement newReimbursement = new Reimbursement();
				
				rbs.addReimbursement(newReimbursement);
				
				break;
			}
				
				
				case "updateStatus": {
				
				System.out.println("Enter Reimbursement status ID to change");
				int reimb_status_idInput = scan.nextInt();
				
				System.out.println("Enter a new Status for this ID");
				String statusInput = scan.nextLine();
				scan.nextLine();
				
				}				
				
				
				
			
			case "exit": {
				displayMenu = false;
				break;
			}
			
			default: {
				System.out.println("Invalid selection... try again :'( ");
				break;
			}
			
			
			}
			
		}
		
		
	}
	
}
