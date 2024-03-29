package org.example.repositories;

import org.example.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для работы с данными пользователей в базе данных.
 */
@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;

    /**
     * Конструктор для инициализации репозитория с использованием JdbcTemplate.
     *
     * @param jdbc JdbcTemplate для выполнения SQL-запросов.
     */
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Получает список всех пользователей из базы данных.
     *
     * @return Список всех пользователей.
     */
    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getLong("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    /**
     * Сохраняет нового пользователя в базе данных.
     *
     * @param user Пользователь для сохранения.
     * @return Сохраненный пользователь.
     */
    public User save(User user) {
        String sql = "INSERT INTO userTable VALUES (NULL, ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * Удаляет пользователя из базы данных по его идентификатору.
     *
     * @param id Идентификатор пользователя для удаления.
     */
    public void deleteById(Long id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    /**
     * Находит пользователя в базе данных по его идентификатору.
     *
     * @param id Идентификатор пользователя для поиска.
     * @return Найденный пользователь или null, если пользователь не найден.
     */
    public User findById(int id) {
        String sql = "SELECT * FROM userTable WHERE id=?";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getLong("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(sql, new Object[]{id}, userRowMapper).stream().findFirst().orElse(null);
    }

    /**
     * Обновляет данные пользователя в базе данных.
     *
     * @param user Пользователь с обновленными данными.
     */
    public void update(User user) {
        String sql = "UPDATE userTable SET firstName = ?, lastName = ? WHERE id = ?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
    }
}