package com.skillmatch.vlearn.controller;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.skillmatch.vlearn.dto.AuthRequest;
import com.skillmatch.vlearn.dto.RegisterRequest;
import com.skillmatch.vlearn.dto.RegisterResponse;
import com.skillmatch.vlearn.entity.UserEntity;
import com.skillmatch.vlearn.service.AuthService;
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService service;

	@PostMapping("/register")
	public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest user){
		UserEntity savedUser = new UserEntity();
		savedUser.setName(user.getName());
		savedUser.setPassword(user.getPassword());
		savedUser.setEmail(user.getEmail());
		savedUser.setDob(user.getDob());
		savedUser.setPhone(user.getPhone());
		UserEntity respUser = service.register(savedUser);
		RegisterResponse resp = new RegisterResponse();
		if(respUser == null) {
			resp.setUser(null);
			resp.setUserID("User aldready Exists");
			resp.setTimestamp(LocalDateTime.now());
			resp.setMsg("Email aldready exists");
			resp.setStatus_code(HttpStatus.ALREADY_REPORTED.value());
		}else {
			resp.setUser(respUser);
			resp.setUserID(respUser.getId());
			resp.setTimestamp(LocalDateTime.now());
			resp.setMsg("User Created Successfully");
			resp.setStatus_code(HttpStatus.CREATED.value());
		}
		return ResponseEntity.status(resp.getStatus_code()).body(resp);
	}
	@PostMapping("/login")
	public String login(@RequestBody AuthRequest user) {
		
		return service.verify(user);
	}
	
}
