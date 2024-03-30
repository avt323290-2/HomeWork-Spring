package com.example.HW12.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Модель для представления заметок.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Note {
    /**
     * Идентификационный номер заметки.
     */
    private Long id;

    /**
     * Заголовок заметки.
     */
    private String title;

    /**
     * Тело заметки.
     */
    private String body;

    /**
     * Дата и время создания заметки.
     */
    private LocalDateTime creation;

    /**
     * Конструктор класса Note.
     * @param title Заголовок заметки.
     * @param body Тело заметки.
     */
    public Note(String title, String body) {
        this.title = title;
        this.body = body;
    }
}