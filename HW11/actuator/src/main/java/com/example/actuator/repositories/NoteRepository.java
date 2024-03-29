package com.example.actuator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.actuator.models.Note;

/**
 * Репозиторий для работы с сущностью заметки.
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    // Можно добавить дополнительные методы для работы с заметками
    // Например, методы для поиска заметок по заголовку или дате создания
}