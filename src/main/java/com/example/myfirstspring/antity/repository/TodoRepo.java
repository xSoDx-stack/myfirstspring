package com.example.myfirstspring.antity.repository;

import com.example.myfirstspring.antity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface TodoRepo extends CrudRepository<TodoEntity, UUID> {
}
