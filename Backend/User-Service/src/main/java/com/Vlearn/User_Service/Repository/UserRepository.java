package com.Vlearn.User_Service.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Vlearn.User_Service.Entity.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String>{
	public UserEntity findByEmail(String email);
}
