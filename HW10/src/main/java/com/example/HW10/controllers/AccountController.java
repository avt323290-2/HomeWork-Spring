package com.example.HW10.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.HW10.dto.TransferRequest;
import com.example.HW10.model.Account;
import com.example.HW10.services.TransferService;

@AllArgsConstructor
@RestController
public class AccountController {

    private final TransferService transferService;

    /**
     * Перевод денег между счетами.
     *
     * @param request объект запроса на перевод денег
     */
    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest request
    ) {
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }

    /**
     * Получение списка всех счетов или счетов по имени.
     *
     * @param name имя владельца счета (необязательный параметр)
     * @return список всех счетов или счетов с указанным именем
     */
    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(
            @RequestParam(required = false) String name
    ) {
        if (name == null) {
            return transferService.getAllAccounts();
        } else {
            return transferService.findAccountsByName(name);
        }
    }

}