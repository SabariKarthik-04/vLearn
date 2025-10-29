package com.Vlearn.User_Service.DTO.userDTOs;

import com.Vlearn.User_Service.DTO.ResponseDTO;
import com.Vlearn.User_Service.Entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class SaveUserResponseDTO extends ResponseDTO{
	private UserEntity user;
}
