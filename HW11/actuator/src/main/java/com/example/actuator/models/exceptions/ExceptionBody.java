package com.example.actuator.models.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Обертка для сообщений об исключении.
 */
@Data
public class ExceptionBody {
    /**
     * Сообщение об исключении.
     */
    private String message;
    /**
     * Время создания.
     */
    private LocalDateTime localDateTime;

}