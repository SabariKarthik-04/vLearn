package com.Vlearn.User_Service.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Vlearn.User_Service.Entity.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String>{
	public Optional<UserEntity> findByEmail(String email);
}
