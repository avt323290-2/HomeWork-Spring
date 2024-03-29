package com.example.actuator.controllers;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.actuator.models.Note;
import com.example.actuator.services.NoteService;

import java.util.List;

/**
 * Контроллер для работы с заметками.
 */
@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final Counter requestCounter = Metrics.counter("request_count");

    /**
     * Сервис для работы с заметками.
     */
    private final NoteService noteService;

    /**
     * Получение всех заметок.
     * @return ответ со списком заметок.
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        requestCounter.increment();
        List<Note> notes = noteService.getAllNotes();
        return ResponseEntity.ok().body(notes);
    }

    /**
     * Получение заметки по идентификатору.
     * @param id идентификатор заметки.
     * @return ответ с заметкой.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Note note = noteService.getNoteById(id);
        return ResponseEntity.ok().body(note);
    }

    /**
     * Создание новой заметки.
     * @param note объект новой заметки.
     * @return ответ с созданной заметкой.
     */
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note createdNote = noteService.createNote(note);
        return ResponseEntity.ok().body(createdNote);
    }

    /**
     * Обновление существующей заметки.
     * @param id идентификатор заметки.
     * @param updatedNote объект обновленной заметки.
     * @return ответ с обновленной заметкой.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note updatedNote) {
        Note note = noteService.updateNote(id, updatedNote);
        return ResponseEntity.ok().body(note);
    }

    /**
     * Удаление заметки по идентификатору.
     * @param id идентификатор заметки.
     * @return ответ со статусом успешного удаления.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.removeNote(id);
        return ResponseEntity.noContent().build();
    }
}