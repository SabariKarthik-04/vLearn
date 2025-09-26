package com.Vlearn.User_Service.Entity;

import java.time.LocalDate;
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
	private String createdAt = String.valueOf(LocalDate.now());
	private String updatedAt; 
}
