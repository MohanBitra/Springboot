package com.test.springboottest.springrestful;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserResourceService {

	private static List<User> listofUsers = new ArrayList<User>();

	static {

		listofUsers.add(new User(1, "apple", new Date()));
		listofUsers.add(new User(2, "mango", new Date()));
		listofUsers.add(new User(3, "Orange", new Date()));
	}

	public List<User> retrieveUsers() {

		return listofUsers;

	}
	
	
	public User retrieveUser(int id) {

		for (User user : listofUsers) {

			if (user.getId() == id) {
				return user;

			}

		}

		return null;

	}
	
	public User saveUser(User user) {
		
		listofUsers.add(user);
		
		return user;
		
	}
	
	public User deleteUser(int id) {
		
		int count = 0;
		
		for (User user : listofUsers) {

			if (user.getId() == id) {
				listofUsers.remove(count);
				return user;

			}
			
			count++;

		}	
		
		return null;
		
	}
	
	
	

}
