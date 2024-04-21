package com.lcwd.user.service.exceptions;

public class ResourseNotFoundException extends RuntimeException{
	
	
	
	//constructors
	public ResourseNotFoundException() {
		super("Resource not found on server !! ");
	}
	public ResourseNotFoundException(String message) {
		super(message);
	}

}
