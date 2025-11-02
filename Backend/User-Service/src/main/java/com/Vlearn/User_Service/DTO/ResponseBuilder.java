package com.Vlearn.User_Service.DTO;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.Vlearn.User_Service.DTO.userDTOs.UserResponseDTO;
import com.Vlearn.User_Service.Entity.UserEntity;

public class ResponseBuilder {
	public static UserResponseDTO buildSuccess(UserEntity user, String message,HttpStatus status) {
		UserResponseDTO resp = new UserResponseDTO();
        resp.setUserid(user.getId());
        resp.setUser(user);
        resp.setMessage(message);
        resp.setTimeStamp(LocalDateTime.now());
        resp.setHttpStatus(status.name());
        resp.setHttpStatusCode(status.value());
        return resp;
	}
	
}
