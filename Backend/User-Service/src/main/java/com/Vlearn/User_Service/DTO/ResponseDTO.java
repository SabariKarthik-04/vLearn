package com.Vlearn.User_Service.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResponseDTO {
	private String userid;
	private LocalDateTime timeStamp;
	private int httpStatusCode;
	private String httpStatus;
	private String message;
}
