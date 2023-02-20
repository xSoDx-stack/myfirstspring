package com.example.myfirstspring.controller;

import com.example.myfirstspring.antity.TodoEntity;
import com.example.myfirstspring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    @Autowired
    private TodoService todoService;
    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam UUID userId){
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));

        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @PutMapping
    public ResponseEntity completeTodo(@RequestParam UUID id){
        try {
            return ResponseEntity.ok(todoService.completeTodo(id));


        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");

        }
    }
}
