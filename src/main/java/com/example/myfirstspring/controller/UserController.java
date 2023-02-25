package com.example.myfirstspring.controller;

import com.example.myfirstspring.antity.UserEntity;
import com.example.myfirstspring.exceptions.UserEmailAlreadyExistException;
import com.example.myfirstspring.exceptions.UserNotFoundException;
import com.example.myfirstspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
              return ResponseEntity.ok("Пользователь успешно сохранён");
        }catch(UserEmailAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Ошибка запроса");
        }
    }
    @GetMapping
    public ResponseEntity<?> getOneUser(@RequestParam String UserEmail) {
        try{
           return ResponseEntity.ok(userService.getOne(UserEmail));
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка запроса");
        }
    }
    @DeleteMapping("/{UserEmail}")
    public ResponseEntity<?> deleteUser(@PathVariable String UserEmail){
        try{
            return ResponseEntity.ok(userService.delete(UserEmail));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Не удалось удалить пользователя");
        }
    }
}
