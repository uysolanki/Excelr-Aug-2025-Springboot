package com.excelr.shopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handlePlayerNotFound(RuntimeException ex)
	{ 
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<String> handlePlayerNotFound(ResourseNotFoundException ex)
	{ 
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}



}
