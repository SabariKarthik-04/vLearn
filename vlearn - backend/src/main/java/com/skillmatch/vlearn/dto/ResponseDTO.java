package com.skillmatch.vlearn.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResponseDTO {
	private String userID;
	private LocalDateTime timestamp;
	private int status_code;
	private String msg;
}
