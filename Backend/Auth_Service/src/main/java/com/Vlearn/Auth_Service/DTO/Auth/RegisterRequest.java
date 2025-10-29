package com.Vlearn.Auth_Service.DTO.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {

	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String password;
}
