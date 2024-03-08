package org.example.model;

import java.util.Objects;
import org.example.model.User;

/**
 * Класс, представляющий сущность пользователя.
 */
public class User {

    private int id;           // Уникальный идентификатор пользователя
    private String firstName; // Имя пользователя
    private String lastName;  // Фамилия пользователя

    /**
     * Метод для получения уникального идентификатора пользователя.
     *
     * @return уникальный идентификатор пользователя
     */
    public int getId() {
        return id;
    }

    /**
     * Метод для установки уникального идентификатора пользователя.
     *
     * @param id уникальный идентификатор пользователя
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Метод для получения имени пользователя.
     *
     * @return имя пользователя
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Метод для установки имени пользователя.
     *
     * @param firstName имя пользователя
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Метод для получения фамилии пользователя.
     *
     * @return фамилия пользователя
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Метод для установки фамилии пользователя.
     *
     * @param lastName фамилия пользователя
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Переопределение метода equals для сравнения пользователей по идентификатору, имени и фамилии.
     *
     * @param o объект для сравнения
     * @return true, если пользователи равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.getFirstName()) && Objects.equals(lastName, user.getLastName());
    }

    /**
     * Переопределение метода hashCode для генерации хеш-кода на основе идентификатора, имени и фамилии пользователя.
     *
     * @return хеш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}