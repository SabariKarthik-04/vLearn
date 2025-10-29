package com.Vlearn.User_Service.DTO.userDTOs;

import java.util.List;

import com.Vlearn.User_Service.Entity.Skill;

import lombok.Data;

@Data
public class UpdateUserRequestDTO {
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNumber; 
	private String dateOfBirth;
	private List<Skill> skills;
	private String bio;
}
