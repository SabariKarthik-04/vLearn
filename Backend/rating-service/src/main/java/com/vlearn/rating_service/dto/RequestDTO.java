package com.vlearn.rating_service.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RequestDTO {
	private String userId;
	private LocalDateTime timestamp;
}
