package com.lcwd.user.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.user.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ApiResponse> HandlerResourseNotFoundException(ResourseNotFoundException ex){
		
		String message = ex.getMessage();
		//ApiResponse response = ApiResponse.Builder;
		return null;//ResponseEntity<ApiResponse>(res);
		
		
	}

}
