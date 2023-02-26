package com.example.myfirstspring.repository;

import com.example.myfirstspring.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface TodoRepo extends CrudRepository<TodoEntity, UUID> {
    TodoEntity findByUserUserEmail (String Email);
}
