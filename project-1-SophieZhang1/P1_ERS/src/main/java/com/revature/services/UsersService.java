package com.revature.services;

import java.util.List;
import com.revature.models.Users;
import com.revature.repositories.UsersDAO;


public class UsersService {

	UsersDAO uDAO = new UsersDAO(); 
		
		public List<Users> getUsers() {
			
			List<Users> Users = uDAO.getUsers();
			
			return Users;
		}
		
		public void addUsers(Users newUsers) {
			
			uDAO.insertUsers(newUsers);
		}

		public List<Users> getUsersByuser_id(int user_idInput) {
			
			List<Users> users = getUsersByuser_id(user_idInput);
			
			return users;
		}

		public List<Users> getUsersByUsername(String usernameInput) {
			
			List<Users> Users = getUsersByUsername(usernameInput);
			
			return Users;
		}
		
        public List<Users> getUsersByRole(String roleInput) {
			
			List<Users> Users = getUsersByRole(roleInput);
			
			return Users;
		}
        
                
       	public void updateUsers(Users users) {
			
			uDAO.updateUsers(users);
			
		}
		
        public boolean deleteUsers(int user_id) {
			
		
		return uDAO.deleteUsers(user_id);
			
		}

		public Object getByUsername(String username) {
			return null;
		}

			
    }





/**
 * The UserService should handle the processing and retrieval of Users for the ERS application.
 *
 * {@code getByUsername} is the only method required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create User</li>
 *     <li>Update User Information</li>
 *     <li>Get Users by ID</li>
 *     <li>Get Users by Email</li>
 *     <li>Get All Users</li>
 * </ul>
 */
/**
 *     Should retrieve a User with the corresponding username or an empty optional if there is no match.
 */
		
	