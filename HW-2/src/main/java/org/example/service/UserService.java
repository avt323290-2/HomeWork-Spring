package org.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.homeWork2.model.User;
import ru.geekbrains.homeWork2.repositories.UserRepository;
import java.util.List;

/**
 * Сервис для выполнения операций с пользователями.
 */
@Service
public class UserService {

    private final UserRepository userRepository; // Репозиторий для работы с пользователями

    /**
     * Конструктор сервиса.
     *
     * @param userRepository репозиторий для работы с пользователями
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Метод для поиска всех пользователей.
     *
     * @return список всех пользователей
     */
    public List<User> findAll(){
        return userRepository.findAll();
    }

    /**
     * Метод для сохранения пользователя.
     *
     * @param user пользователь для сохранения
     * @return сохраненный пользователь
     */
    public User saveUser(User user){
        return userRepository.save(user);
    }

    /**
     * Метод для удаления пользователя по его идентификатору.
     *
     * @param id идентификатор пользователя для удаления
     */
    public void deleteById(int id){
        userRepository.deleteById(id);
    }
}