package com.example.HW10.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TransferRequest {

    /**
     * Идентификатор счета отправителя.
     */
    private long senderAccountId;

    /**
     * Идентификатор счета получателя.
     */
    private long receiverAccountId;

    /**
     * Сумма перевода.
     */
    private BigDecimal amount;
}