package com.example.myfirstspring.controller;

import com.example.myfirstspring.entity.TodoEntity;
import com.example.myfirstspring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    private final TodoService todoService;
    @Autowired
    public ToDoController (TodoService todoService){
        this.todoService = todoService;
    }
    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam String UserEmail){
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, UserEmail));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @PutMapping
    public ResponseEntity<?> completeTodo(@RequestParam String UserEmail){
        try {
            return ResponseEntity.ok(todoService.completeTodo(UserEmail));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
