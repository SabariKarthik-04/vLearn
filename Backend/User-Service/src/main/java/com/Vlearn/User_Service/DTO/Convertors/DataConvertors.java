package com.Vlearn.User_Service.DTO.Convertors;

import org.springframework.stereotype.Component;

import com.Vlearn.User_Service.DTO.userDTOs.SaveUserDTO;
import com.Vlearn.User_Service.Entity.UserEntity;

@Component
public class DataConvertors {

	public UserEntity saveCoverter(SaveUserDTO user) {
		try {
			if(user == null) return null;
			else {
				UserEntity saveableUser = new UserEntity();
				saveableUser.setFirstName(user.getFirstName());
				saveableUser.setLastName(user.getLastName());
				saveableUser.setMiddleName(user.getMiddleName().isEmpty()?null:user.getMiddleName());
				saveableUser.setEmail(user.getEmail());
				saveableUser.setPhoneNumber(user.getPhoneNumber());
				saveableUser.setDateOfBirth(user.getDateOfBirth());
				saveableUser.setSkills(user.getSkills());
				saveableUser.setBio(user.getBio());
				return saveableUser;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
