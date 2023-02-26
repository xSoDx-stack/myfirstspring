package com.example.myfirstspring.repository;

import com.example.myfirstspring.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

public interface UserRepo extends CrudRepository<UserEntity, UUID> {
    UserEntity findByUserEmail(String userEmail);
    @Transactional
    void deleteByUserEmail(String userEmail);
}

