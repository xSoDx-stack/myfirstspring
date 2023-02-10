package com.example.myfirstspring.antity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String userEmail;
    private String username;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TodoEntity> todos;

    public UserEntity() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}