package com.stg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResponseErrorHandler;


@ControllerAdvice
public class GlobalExceptions  {
	
	public GlobalExceptions() {
		super();
		
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> handleThis(CustomException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}


	
	
	
}