package com.example.myfirstspring.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "todo")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String Title;
    private Boolean completed;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public TodoEntity() {
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
