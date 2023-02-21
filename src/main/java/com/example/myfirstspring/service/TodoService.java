package com.example.myfirstspring.service;

import com.example.myfirstspring.antity.TodoEntity;
import com.example.myfirstspring.antity.UserEntity;
import com.example.myfirstspring.antity.repository.TodoRepo;
import com.example.myfirstspring.antity.repository.UserRepo;
import com.example.myfirstspring.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

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
