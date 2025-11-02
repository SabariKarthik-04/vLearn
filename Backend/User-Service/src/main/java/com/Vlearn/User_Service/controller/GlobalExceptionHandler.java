package com.Vlearn.User_Service.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Vlearn.User_Service.DTO.ErrorResponse;
import com.Vlearn.User_Service.Exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(exception = UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException exception){
		ErrorResponse response = new ErrorResponse(LocalDateTime.now(), exception.getMessage(), "User Not Found");
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity<ErrorResponse> handleExeception(Exception ex){
		ErrorResponse response = new ErrorResponse(LocalDateTime.now(),ex.getMessage(), "Something Went Wrong");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
		
}
