package com.lcwd.user.service.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.Impl.UserServiceImpl;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	private UserService userServ;
	@Autowired
    public void setUserServ(UserService userServ){
        this.userServ = userServ;
    }
	//Create
	@PostMapping("/postdata")
	public ResponseEntity<User> createUser(@RequestBody User users){
		
		
		
		User saveUser = userServ.saveUser(users);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		
		User getUser = userServ.getUser(userId);
		return ResponseEntity.ok(getUser);
	}
	
	@GetMapping("/getuser")
	public ResponseEntity<List<User>> getAllUser(){
		
		List<User> allUser = userServ.getAlUsers();
		
		return ResponseEntity.ok(allUser);
	}
	
	/*
	 * @GetMapping("user/{userId}") public ResponseEntity<List<Rating>>
	 * getRatingByuserId(@PathVariable String userId){
	 * 
	 * //List<Rating> getRatingByuserId = ratingServ.getRatingbyUserId(userId);
	 * return ResponseEntity.ok(ratingServ.getRatingbyhoteid(userId)); }
	 */
	@GetMapping("/home")
	public String home() {
		
		return "In Home";
	}
	
}
