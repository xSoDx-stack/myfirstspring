package com.example.myfirstspring.service;

import com.example.myfirstspring.entity.TodoEntity;
import com.example.myfirstspring.entity.UserEntity;
import com.example.myfirstspring.repository.TodoRepo;
import com.example.myfirstspring.repository.UserRepo;
import com.example.myfirstspring.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final TodoRepo todoRepo;
    private final UserRepo userRepo;
    @Autowired
    public TodoService(TodoRepo todoRepo, UserRepo userRepo){
        this.todoRepo = todoRepo;
        this.userRepo = userRepo;
    }

    public Todo createTodo(TodoEntity todo, String userEmail){
        UserEntity user = userRepo.findByUserEmail(userEmail);
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }
    public Todo completeTodo(String email){
        TodoEntity todo = todoRepo.findByUserUserEmail(email);
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));


    }
}
