package com.Vlearn.Auth_Service.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Vlearn.Auth_Service.DTO.Auth.LoginRequest;
import com.Vlearn.Auth_Service.DTO.Auth.LoginResponse;
import com.Vlearn.Auth_Service.DTO.Auth.RegisterRequest;
import com.Vlearn.Auth_Service.DTO.Auth.RegisterResponse;
import com.Vlearn.Auth_Service.Entity.UserEntity;
import com.Vlearn.Auth_Service.Service.AuthService;

import jakarta.validation.Valid;

@RestController
public class AuthController {
	
	private final AuthService service;

    AuthController(AuthService service) {
        this.service = service;
    }

	@PostMapping("/register")
	public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest user) throws Exception{
		UserEntity saveUser = new UserEntity();
		saveUser.setEmail(user.getEmail());
		saveUser.setPassword(user.getPassword());
		RegisterResponse resp = new RegisterResponse();
		String token = service.register(saveUser);
		resp.setToken(token);
		return ResponseEntity.ok(resp);
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest user) throws Exception{
		LoginResponse resp = new LoginResponse();
		String token = service.login(user.getEmail(), user.getPassword());
		resp.setToken(token);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(resp);
		
	}
	
	@GetMapping("/validate")
	public ResponseEntity<?> validate(@RequestParam String token){
		boolean valid = service.validateToken(token);
		if(valid) {
			return ResponseEntity.ok(true);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
	}
	
}
