package com.example.myfirstspring.service;

import com.example.myfirstspring.antity.UserEntity;
import com.example.myfirstspring.antity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



//@Service
//public class UserService {
//    @Autowired
//    private UserRepo userRepo;
//
//    public UserEntity registratoin(UserEntity user){
//        if (userRepo.findAllById(user.getUserEmail()) != null){
//
//        }
//        return ResponseEntity.ok("Пользователь успешно сохранён");
//    }
//}
