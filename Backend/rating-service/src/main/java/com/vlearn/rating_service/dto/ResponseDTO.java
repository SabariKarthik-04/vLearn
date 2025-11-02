package com.vlearn.rating_service.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResponseDTO {
	private LocalDateTime timeStamp;
	private int httpStatusCode;
	private String httpStatus;
	private String message;
}
