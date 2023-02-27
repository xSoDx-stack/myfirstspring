package com.example.myfirstspring.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NonNull
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public RoleEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
