package com.example.actuator.services;

import com.example.actuator.models.Note;

import java.util.List;

public interface NoteService {
    /**
     * Получение всех заметок.
     * @return список всех заметок.
     */
    List<Note> getAllNotes();

    /**
     * Получение конкретной заметки по идентификатору.
     * @param id идентификатор заметки.
     * @return объект заметки или null, если заметка не найдена.
     */
    Note getNoteById(Long id);

    /**
     * Создание новой заметки.
     * @param note объект заметки для создания.
     * @return созданный объект заметки.
     */
    Note createNote(Note note);

    /**
     * Обновление существующей заметки по идентификатору.
     * @param id идентификатор заметки для обновления.
     * @param note объект заметки с обновленными данными.
     * @return обновленный объект заметки или null, если заметка не найдена.
     */
    Note updateNote(Long id, Note note);

    /**
     * Удаление заметки по идентификатору.
     * @param id идентификатор заметки для удаления.
     */
    void deleteNoteById(Long id);

    void removeNote(Long id);
}