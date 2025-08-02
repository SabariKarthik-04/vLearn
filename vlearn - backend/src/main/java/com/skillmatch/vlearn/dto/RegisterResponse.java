package com.skillmatch.vlearn.dto;

import com.skillmatch.vlearn.entity.UserEntity;

import lombok.Data;

@Data
public class RegisterResponse extends ResponseDTO {
	private UserEntity user;
	
	
}
