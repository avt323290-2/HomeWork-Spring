package com.example.actuator.models.exceptions;

/**
 * Исключение при отсутствии данных в БД.
 */
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}