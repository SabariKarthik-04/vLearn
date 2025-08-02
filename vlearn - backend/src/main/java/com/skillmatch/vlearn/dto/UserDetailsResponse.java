package com.skillmatch.vlearn.dto;

import com.skillmatch.vlearn.entity.UserDetails;

import lombok.Data;

@Data
public class UserDetailsResponse extends ResponseDTO{
	
	private UserDetails user;
	
}
