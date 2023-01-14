package com.example.myfirstspring.controller;

import com.example.myfirstspring.antity.UserEntity;
import com.example.myfirstspring.exceptions.UserEmailAlreadyExistException;
import com.example.myfirstspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registratoin(user);
              return ResponseEntity.ok("Пользователь успешно сохранён");
        }catch(UserEmailAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser() {
        try{
            return ResponseEntity.ok("Server works ! ");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
