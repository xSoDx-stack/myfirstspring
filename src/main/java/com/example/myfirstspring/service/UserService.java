package com.example.myfirstspring.service;

import com.example.myfirstspring.antity.UserEntity;
import com.example.myfirstspring.antity.repository.UserRepo;
import com.example.myfirstspring.exceptions.UserEmailAlreadyExistException;
import com.example.myfirstspring.exceptions.UserNotFoundException;
import com.example.myfirstspring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public void registration(UserEntity user) throws UserEmailAlreadyExistException {
            if (userRepo.findByUserEmail(user.getUserEmail()) != null) {
                throw new UserEmailAlreadyExistException("Пользователь с такой почтой уже зарегестрирован");
            }
        userRepo.save(user);
    }
    public User getOne(String userEmail) throws UserNotFoundException {
        UserEntity userMail = userRepo.findByUserEmail(userEmail);
        if (userMail == null){
            throw new UserNotFoundException("Пользователя с такой почтой не существует");
        }
        return User.toModel(userMail);
    }
    public String delete(String Email){
        if(userRepo.findByUserEmail(Email) == null)
            return "Пользователя с такой почтой не существует";
        userRepo.deleteByUserEmail(Email);
        return "Пользователь с почтой " + Email + " успешно удалён";
    }
}
