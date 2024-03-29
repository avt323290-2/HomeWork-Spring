package org.example.model;

import lombok.Data;
import javax.persistence.*;

/**
 * Модель пользователя.
 */
@Data
@Entity
@Table(name = "userTable")
public class User {
    /**
     * Идентификатор пользователя.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя пользователя.
     */
    @Column
    private String firstName;

    /**
     * Фамилия пользователя.
     */
    @Column
    private String lastName;
}