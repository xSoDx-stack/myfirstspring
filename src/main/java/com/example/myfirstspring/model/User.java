package com.example.myfirstspring.model;

import com.example.myfirstspring.antity.UserEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class User {
    private UUID id;
    private String userEmail;
    private String username;
    private List<Todo> todos;

    public static User toModel (UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setUserEmail(entity.getUserEmail());
        model.setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;

    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
