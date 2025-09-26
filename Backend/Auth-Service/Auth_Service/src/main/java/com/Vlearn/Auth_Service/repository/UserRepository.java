package com.Vlearn.Auth_Service.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Vlearn.Auth_Service.Entity.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
	Optional<UserEntity> findByEmail(String email);
}
