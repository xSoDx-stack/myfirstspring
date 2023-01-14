package com.example.myfirstspring.service;

import com.example.myfirstspring.antity.UserEntity;
import com.example.myfirstspring.antity.repository.UserRepo;
import com.example.myfirstspring.exceptions.UserEmailAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public UserEntity registratoin(@RequestBody UserEntity user) throws UserEmailAlreadyExistException {
            if (userRepo.findByUserEmail(user.getUserEmail()) != null) {
                throw new UserEmailAlreadyExistException("Пользователь с такой почтой уже зарегестрирован");
            }
            return userRepo.save(user);
    }
}
