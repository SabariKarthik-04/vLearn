package com.Vlearn.Auth_Service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
public class AuthController {
	
	@Autowired
	private AuthService service;

	@PostMapping("/register")
	public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest user){
		UserEntity saveUser = new UserEntity();
		saveUser.setEmail(user.getEmail());
		saveUser.setPassword(user.getPassword());
		RegisterResponse resp = new RegisterResponse();
		try {
			String token = service.register(saveUser);
			if(resp.equals("null")) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			resp.setToken(token);
		} catch (Exception e) {
			throw e;
		}
		return ResponseEntity.ok(resp);
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest user){
		LoginResponse resp = new LoginResponse();
		try {
			System.out.println(user);
			String token = service.login(user.getEmail(), user.getPassword());
			if(token.equals("null")) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			resp.setToken(token);
		} catch (Exception e) {
			throw e;
		}
		return ResponseEntity.ok(resp);
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
