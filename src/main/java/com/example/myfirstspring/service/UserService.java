package com.example.myfirstspring.service;

import com.example.myfirstspring.antity.UserEntity;
import com.example.myfirstspring.antity.repository.UserRepo;
import com.example.myfirstspring.exceptions.UserEmailAlreadyExistException;
import com.example.myfirstspring.exceptions.UserNotFoundException;
import com.example.myfirstspring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public UserEntity registration(UserEntity user) throws UserEmailAlreadyExistException {
            if (userRepo.findByUserEmail(user.getUserEmail()) != null) {
                throw new UserEmailAlreadyExistException("Пользователь с такой почтой уже зарегестрирован");
            }
            return userRepo.save(user);
    }
    public User getOne(String userMail) throws UserNotFoundException {
        UserEntity userEmail = userRepo.findByUserEmail(userMail);
        if (userEmail == null){
            throw new UserNotFoundException("Пользователя с такой почтой не существует");
        }
        return User.toModel(userEmail);
    }
    public UUID delete(UUID id){
        userRepo.deleteById(id);
        return id;
    }
}
