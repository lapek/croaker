package com.raven.croaker.exception;

public class UserCreationErrorException extends RuntimeException {
    public UserCreationErrorException(String message) {
        super(message);
    }
}
