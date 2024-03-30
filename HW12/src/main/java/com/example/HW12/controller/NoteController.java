package com.example.HW12.controller;

import com.example.HW12.model.Note;
import com.example.HW12.services.FileGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final FileGateway fileGateway;

    /**
     * Обрабатывает POST-запрос для добавления новой заметки.
     * Создает файл с названием, соответствующим заголовку заметки, и записывает содержание заметки в этот файл.
     * @param note Заметка, которую необходимо добавить.
     * @return ResponseEntity<Void>
     */
    @PostMapping
    public ResponseEntity<Void> addNote(@RequestBody Note note) {
        note.setCreation(LocalDateTime.now());
        fileGateway.writeToFile(note.getTitle() + ".txt", note.toString());
        return ResponseEntity.ok().build();
    }
}