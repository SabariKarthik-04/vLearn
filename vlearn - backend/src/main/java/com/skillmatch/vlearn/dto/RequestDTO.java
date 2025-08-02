package com.skillmatch.vlearn.dto;


import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RequestDTO{
	private String UserId;
	private LocalDateTime timestamp;
}

