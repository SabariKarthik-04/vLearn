package com.Vlearn.User_Service.service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.Vlearn.User_Service.DTO.Convertors.DataConvertors;
import com.Vlearn.User_Service.DTO.userDTOs.SaveUserDTO;
import com.Vlearn.User_Service.DTO.userDTOs.UpdateUserRequestDTO;
import com.Vlearn.User_Service.Entity.Skill;
import com.Vlearn.User_Service.Entity.UserEntity;
import com.Vlearn.User_Service.Repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository repo;
	private final DataConvertors conv;
	
	public UserService(UserRepository repo,DataConvertors conv){
		this.repo = repo;
		this.conv = conv;
	}
	
	public boolean userExistsChecker(String email) {
		return repo.findByEmail(email) != null;
	}
	
	public UserEntity saveUserDetails(SaveUserDTO entity) {
		try {
			UserEntity save = conv.saveCoverter(entity);
			if(save == null) return null;
			return repo.save(save);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public UserEntity updateUserDetails(UpdateUserRequestDTO newUser,String email) {
		try {
			UserEntity oldUser = repo.findByEmail(email);
			if(oldUser!=null) {
				updateEntity(oldUser, newUser);
				repo.save(oldUser);
				return oldUser;
			}else return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	private void updateEntity(UserEntity oldUser, UpdateUserRequestDTO update) {
	    if (update == null || oldUser == null) return;
	    try {
	        oldUser.setFirstName(update.getFirstName() == null ? oldUser.getFirstName() : update.getFirstName());
	        oldUser.setMiddleName(update.getMiddleName() == null ? oldUser.getMiddleName() : update.getMiddleName());
	        oldUser.setLastName(update.getLastName() == null ? oldUser.getLastName() : update.getLastName());
	        oldUser.setPhoneNumber(update.getPhoneNumber() == null ? oldUser.getPhoneNumber() : update.getPhoneNumber());
	        oldUser.setDateOfBirth(update.getDateOfBirth() == null ? oldUser.getDateOfBirth() : update.getDateOfBirth());
	        List<Skill> updatedSkills = update.getSkills();
	        if (updatedSkills != null && !updatedSkills.isEmpty()) {
	            oldUser.setSkills(remDuplicate(updatedSkills,
	                    oldUser.getSkills() == null ? new ArrayList<>() : oldUser.getSkills()));
	        }
	        oldUser.setBio(update.getBio() == null ? oldUser.getBio() : update.getBio());
	        oldUser.setUpdatedAt(String.valueOf(LocalDateTime.now()));
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    }
	}
	
	private List<Skill> remDuplicate(List<Skill> newSkills,List<Skill> oldSkills) {
	    Set<String> seenNames = new HashSet<>();
	    List<Skill> uniqueSkills = new ArrayList<>();

	    for (Skill skill : oldSkills) {
	        if (seenNames.add(skill.getSkill().toLowerCase())) {
	            uniqueSkills.add(skill);
	        }
	    }
	    for (Skill skill : newSkills) {
	        if (seenNames.add(skill.getSkill().toLowerCase())) {
	            uniqueSkills.add(skill);
	        }
	    }

	    return uniqueSkills;
	}
}
