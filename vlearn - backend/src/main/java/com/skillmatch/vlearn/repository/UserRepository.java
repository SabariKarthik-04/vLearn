package com.skillmatch.vlearn.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.skillmatch.vlearn.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {
	Optional<UserEntity> findByEmail(String email);
}
