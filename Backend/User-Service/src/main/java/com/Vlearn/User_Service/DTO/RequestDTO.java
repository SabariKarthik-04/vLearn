package com.Vlearn.User_Service.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RequestDTO {
	private String userid;
	private LocalDateTime timeStamp;
}
