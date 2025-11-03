package com.Vlearn.User_Service.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Vlearn.User_Service.DTO.ResponseBuilder;
import com.Vlearn.User_Service.DTO.userDTOs.SaveUserDTO;
import com.Vlearn.User_Service.DTO.userDTOs.UpdateUserRequestDTO;
import com.Vlearn.User_Service.DTO.userDTOs.UserResponseDTO;
import com.Vlearn.User_Service.Entity.UserEntity;
import com.Vlearn.User_Service.Exception.UserNotFoundException;
import com.Vlearn.User_Service.service.UserService;


@RestController
public class UserDataController {

	private final UserService service;
	
	UserDataController(UserService service){
		this.service = service;
	}
	
	@PostMapping("/save-user")
	public ResponseEntity<UserResponseDTO> SaveUser(@RequestBody SaveUserDTO newUser) throws UserNotFoundException {
		UserEntity user = service.saveUserDetails(newUser);
		UserResponseDTO resp = ResponseBuilder.buildSuccess(user, "User created Sucessfully", HttpStatus.CREATED);
		return ResponseEntity.status(resp.getHttpStatusCode()).body(resp);
	}

	
	@GetMapping("/findbyemail/{email}")
	public ResponseEntity<UserResponseDTO> findByEmail(@PathVariable String email) throws UserNotFoundException{
			UserEntity user = service.getByemail(email);
			UserResponseDTO resp = ResponseBuilder.buildSuccess(user, "User created Sucessfully", HttpStatus.ACCEPTED);	
			return ResponseEntity.status(resp.getHttpStatusCode()).body(resp);
	}	
	
	@PostMapping("/update-user")
	public ResponseEntity<UserResponseDTO> postMethodName(@RequestBody UpdateUserRequestDTO user) throws Exception {
		UserEntity user1 = service.updateUserDetails(user, user.getUserid());
		UserResponseDTO resp = ResponseBuilder.buildSuccess(user1, "User Details Updated Sucessfully", HttpStatus.ACCEPTED);
		return ResponseEntity.status(resp.getHttpStatusCode()).body(resp);
	}
	
}

