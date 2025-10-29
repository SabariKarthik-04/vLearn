package com.Vlearn.User_Service.Entity;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "User_Data")
public class UserEntity {
	
	@Id
	private String id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String dateOfBirth;
	private String bio;
	private List<Skill> skills;
	private String createdAt = String.valueOf(LocalDateTime.now());
	private String updatedAt; 
	
}
