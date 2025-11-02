package com.Vlearn.User_Service.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Vlearn.User_Service.DTO.userDTOs.SaveUserDTO;
import com.Vlearn.User_Service.DTO.userDTOs.SaveUserResponseDTO;
import com.Vlearn.User_Service.Entity.UserEntity;
import com.Vlearn.User_Service.service.UserService;


@RestController
public class UserDataController {

	private final UserService service;
	
	UserDataController(UserService service){
		this.service = service;
	}
	@GetMapping
	public String test() {
		return "hello from user"; 
	}
	
	@PostMapping("/save-user")
	public ResponseEntity<SaveUserResponseDTO> SaveUser(@RequestBody SaveUserDTO newUser) {
		SaveUserResponseDTO resp = new SaveUserResponseDTO();
		try {
			if(service.userExistsChecker(newUser.getEmail())) {
				resp.setMessage("User aldready exists with this email");
				resp.setHttpStatus(HttpStatus.CONFLICT.name());
				resp.setHttpStatusCode(HttpStatus.CONFLICT.value());
				resp.setUser(null);
				resp.setUserid(null);
			}else {
				UserEntity user = service.saveUserDetails(newUser);
				if(user!=null) {
					resp.setMessage("User Saved Successfully");
					resp.setHttpStatus(HttpStatus.CREATED.name());
					resp.setHttpStatusCode(HttpStatus.CREATED.value());
					resp.setUser(user);
					resp.setUserid(user.getId());
				}else {
					resp.setMessage("Some Error Occured!!");
					resp.setHttpStatus(HttpStatus.BAD_REQUEST.name());
					resp.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
					resp.setUser(null);
					resp.setUserid(null);
				}
			}
		} catch (Exception e) {
			resp.setMessage("Some Error Occured!! "+e.getMessage());
			resp.setHttpStatus(HttpStatus.BAD_REQUEST.name());
			resp.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
			resp.setUser(null);
			resp.setUserid(null);
		}
		return ResponseEntity.status(resp.getHttpStatusCode()).body(resp);
	}

}
