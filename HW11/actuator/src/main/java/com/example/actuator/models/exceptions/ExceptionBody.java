package com.example.actuator.models.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Обертка для сообщений об исключении.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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