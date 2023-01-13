package com.example.myfirstspring.exceptions;

public class UserEmailAlreadyExistException extends Exception {
    public UserEmailAlreadyExistException(String message) {
        super(message);
    }
}
