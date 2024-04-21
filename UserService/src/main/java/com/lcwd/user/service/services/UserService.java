package com.lcwd.user.service.services;

import java.util.List;

import com.lcwd.user.service.entities.User;

public interface UserService {
	
	
	//user operations
	
	User saveUser(User user);
	
	List<User> getAlUsers();
	
	User getUser(String userId);
	
		
}
