package com.example.HW10.repositories;

import com.example.HW10.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Репозиторий для работы с сущностью Account.
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

    /**
     * Поиск счетов по имени владельца.
     *
     * @param name имя владельца счета
     * @return список счетов с указанным именем владельца
     */
    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findAccountsByName(String name);

    /**
     * Изменение суммы на счете.
     *
     * @param id идентификатор счета
     * @param amount новая сумма на счете
     */
    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void changeAmount(long id, BigDecimal amount);

}