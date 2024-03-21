package com.example.HW10.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

/**
 * Класс, представляющий сущность счета.
 */
@Data
public class Account {

    /**
     * Идентификатор счета.
     */
    @Id
    private long id;

    /**
     * Имя владельца счета.
     */
    private String name;

    /**
     * Сумма на счете.
     */
    private BigDecimal amount;

}