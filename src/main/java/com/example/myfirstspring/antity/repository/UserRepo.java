package com.example.myfirstspring.antity.repository;

import com.example.myfirstspring.antity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepo extends CrudRepository<UserEntity, UUID> {
    UserEntity findByUserEmail(String userEmail);
}
