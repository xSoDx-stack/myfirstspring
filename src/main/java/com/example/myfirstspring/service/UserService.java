package com.example.myfirstspring.service;

import com.example.myfirstspring.entity.UserEntity;
import com.example.myfirstspring.repository.UserRepo;
import com.example.myfirstspring.exceptions.UserEmailAlreadyExistException;
import com.example.myfirstspring.exceptions.UserNotFoundException;
import com.example.myfirstspring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    public void registration(UserEntity user) throws UserEmailAlreadyExistException {
            if (userRepo.findByUserEmail(user.getUserEmail()) != null) {
                throw new UserEmailAlreadyExistException("Невозможно зарегестрировать пользователя");
            }
        userRepo.save(user);
    }
    public User getOne(String userEmail) throws UserNotFoundException {
        UserEntity user = userRepo.findByUserEmail(userEmail);
        if (user == null){
            throw new UserNotFoundException("Пользователя с такой почтой не существует");
        }
        return User.toModel(user);
    }
    public String delete(String Email){
        if(userRepo.findByUserEmail(Email) == null)
            return "Пользователя с такой почтой не существует";
        userRepo.deleteByUserEmail(Email);
        return "Пользователь с почтой " + Email + " успешно удалён";
    }
}
