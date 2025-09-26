package com.Vlearn.Auth_Service.DTO.Auth;

import lombok.Data;

@Data
public class RegisterRequest {
	private String email;
	private String password;
}
