package com.example.actuator.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.actuator.models.exceptions.ExceptionBody;
import com.example.actuator.models.exceptions.ResourceNotFoundException;

import java.time.LocalDateTime;

/**
 * Контроллер обработки исключений.
 */
@RestControllerAdvice
public class AdviceController {

    /**
     * Обработка исключения ResourceNotFoundException.
     * @param e объект исключения.
     * @return ответ оберткой исключения.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // Изменено на HttpStatus.NOT_FOUND
    public ExceptionBody handleResourceNotFoundException(ResourceNotFoundException e) {
        return createExceptionBody(e.getMessage());
    }

    /**
     * Обработка исключения Exception.
     * @param e объект исключения.
     * @return ответ оберткой исключения.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionBody handleInternalServerError(Exception e) {
        return createExceptionBody("Все пропало, сервер помер!");
    }

    /**
     * Создание объекта ExceptionBody для передачи информации об исключении.
     * @param message сообщение об ошибке.
     * @return объект ExceptionBody.
     */
    private ExceptionBody createExceptionBody(String message) {
        ExceptionBody exceptionBody = new ExceptionBody();
        exceptionBody.setMessage(message);
        exceptionBody.setLocalDateTime(LocalDateTime.now());
        return exceptionBody;
    }
}