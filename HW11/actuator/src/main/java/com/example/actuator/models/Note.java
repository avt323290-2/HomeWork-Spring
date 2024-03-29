package com.example.actuator.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Сущность заметки.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "notes")
public class Note {
    /**
     * Идентификатор.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Заголовок.
     */
    @Column(name = "title")
    private String title;

    /**
     * Содержимое.
     */
    @Column(name = "description")
    private String description;

    /**
     * Дата создания.
     */
    @Column(name = "create_date")
    private LocalDateTime createDate;
}