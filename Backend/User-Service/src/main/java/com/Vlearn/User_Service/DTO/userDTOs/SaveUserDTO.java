package com.Vlearn.User_Service.DTO.userDTOs;

import java.util.List;

import com.Vlearn.User_Service.DTO.RequestDTO;
import com.Vlearn.User_Service.Entity.Skill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
public class SaveUserDTO extends RequestDTO{
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String dateOfBirth;
	private String bio;
	private List<Skill> skills;
	
}
