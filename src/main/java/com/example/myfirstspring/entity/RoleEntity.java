package com.example.myfirstspring.entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
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
    @OneToMany
    private List<UserEntity> users;

}
