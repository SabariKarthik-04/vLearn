package com.vlearn.rating_service.dto.feedbackDTOs;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
