package com.vlearn.rating_service.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vlearn.rating_service.dto.feedbackDTOs.ErrorMessage;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(MentorNotFoundException.class)
    public ResponseEntity<ErrorMessage> mentorNotFoundExceptionHandler (MentorNotFoundException exception){
        ErrorMessage message = new ErrorMessage(LocalDateTime.now(), exception.getMessage(), "Mentor not found with this ID");

        return ResponseEntity.badRequest().body(message);
    }
}
