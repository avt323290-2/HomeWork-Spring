package org.example.repositories;

import org.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс репозитория для управления сущностями пользователей в базе данных.
 */
public interface UserRepo extends JpaRepository<User, Long> {
}