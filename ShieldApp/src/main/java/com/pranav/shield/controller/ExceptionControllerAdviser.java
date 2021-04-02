package com.pranav.shield.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pranav.shield.exception.ContactInfoNotFoundException;
import com.pranav.shield.exception.MissionOutOfRangeException;
import com.pranav.shield.exception.NameNotFoundException;

@RestControllerAdvice
public class ExceptionControllerAdviser {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	} 
	
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<String> handleNameNotFoundException(Exception e) {
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(MissionOutOfRangeException.class)
	public ResponseEntity<String> handleMissionOutOfRangeException(Exception e) {
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(ContactInfoNotFoundException.class)
	public ResponseEntity<String> handleContactInfoNotFoundException(Exception e) {
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
}
