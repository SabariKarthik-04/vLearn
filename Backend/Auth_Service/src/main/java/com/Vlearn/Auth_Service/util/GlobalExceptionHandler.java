package com.Vlearn.Auth_Service.util;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Vlearn.Auth_Service.DTO.Auth.ErrorResponse;
import com.Vlearn.Auth_Service.Exception.InvalidEmailPassException;
import com.Vlearn.Auth_Service.Exception.RegisterException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception e){
		ErrorResponse err = new  ErrorResponse(LocalDateTime.now(), e.getMessage(), "Something Went Wrong");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(exception = InvalidEmailPassException.class)
	public ResponseEntity<ErrorResponse> handleInvalidEmailPassException(InvalidEmailPassException ex){
		ErrorResponse err =  new ErrorResponse(LocalDateTime.now(), ex.getMessage(),ex.getDetail());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
	}
	
	@ExceptionHandler(exception = RegisterException.class)
	public ResponseEntity<ErrorResponse> handleRegisterException(RegisterException ex){
		ErrorResponse err =  new ErrorResponse(LocalDateTime.now(), ex.getMessage(),ex.getDetail());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
	}
}
