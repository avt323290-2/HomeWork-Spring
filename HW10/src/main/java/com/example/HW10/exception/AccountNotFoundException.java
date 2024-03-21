package com.example.HW10.exception;

/**
 * Исключение, выбрасываемое при отсутствии счета.
 */
public class AccountNotFoundException extends RuntimeException {

    /**
     * Создает новое исключение без дополнительного сообщения.
     */
    public AccountNotFoundException() {
        super();
    }

    /**
     * Создает новое исключение с указанным сообщением.
     *
     * @param message сообщение об ошибке
     */
    public AccountNotFoundException(String message) {
        super(message);
    }

    /**
     * Создает новое исключение с указанным сообщением и причиной.
     *
     * @param message сообщение об ошибке
     * @param cause причина исключения
     */
    public AccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}