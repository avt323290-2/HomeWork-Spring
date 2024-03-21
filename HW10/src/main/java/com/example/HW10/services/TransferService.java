package com.example.HW10.services;

import com.example.HW10.exception.AccountNotFoundException;
import com.example.HW10.model.Account;
import com.example.HW10.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Сервис для выполнения операций с переводом средств.
 */
@Service
public class TransferService {

    private final AccountRepository accountRepository;

    /**
     * Конструктор сервиса перевода средств.
     *
     * @param accountRepository репозиторий счетов
     */
    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Перевод денег с одного счета на другой.
     *
     * @param idSender   идентификатор счета отправителя
     * @param idReceiver идентификатор счета получателя
     * @param amount     сумма перевода
     * @throws AccountNotFoundException если счет отправителя или получателя не найден
     */
    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        Account sender = accountRepository.findById(idSender)
                .orElseThrow(() -> new AccountNotFoundException());

        Account receiver = accountRepository.findById(idReceiver)
                .orElseThrow(() -> new AccountNotFoundException());

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    /**
     * Получение списка всех счетов.
     *
     * @return список всех счетов
     */
    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    /**
     * Поиск счетов по имени владельца.
     *
     * @param name имя владельца счета
     * @return список счетов с указанным именем владельца
     */
    public List<Account> findAccountsByName(String name) {
        return accountRepository.findAccountsByName(name);
    }
}