package com.example.HW12.services;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * Интерфейс для шлюза файловой интеграции.
 */
@MessagingGateway(defaultRequestChannel = "textInputChannel")
public interface FileGateway {
    /**
     * Записывает данные в файл с указанным именем.
     * @param filename Имя файла, в который нужно записать данные.
     * @param data Данные для записи в файл.
     */
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, String data);
}