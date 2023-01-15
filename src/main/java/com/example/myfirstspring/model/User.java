package com.example.myfirstspring.model;

import com.example.myfirstspring.antity.UserEntity;

import java.util.UUID;

public class User {
    private UUID id;
    private String userEmail;
    private String username;

    public static User toModel (UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setUserEmail(entity.getUserEmail());
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
}
