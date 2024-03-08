package org.example.repositories;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import HW_2.model.User;
import java.util.List;

/**
 * Репозиторий для выполнения операций с базой данных пользователей.
 */
@Repository
public class UserRepository {

    private final JdbcTemplate jdbc; // Объект JdbcTemplate для выполнения запросов к базе данных

    /**
     * Конструктор репозитория.
     *
     * @param jdbc объект JdbcTemplate для выполнения запросов к базе данных
     */
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Метод для поиска всех пользователей в базе данных.
     *
     * @return список всех пользователей
     */
    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    /**
     * Метод для удаления пользователя из базы данных по его идентификатору.
     *
     * @param id идентификатор пользователя для удаления
     */
    public void deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }
}