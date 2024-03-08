package org.example.controllers;

import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Класс-контроллер для управления операциями, связанными с пользователями.
 */
@Controller
public class UserController {

    private final UserService userService;

    /**
     * Конструктор для UserController.
     *
     * @param userService экземпляр UserService для выполнения операций с пользователями
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Получает список всех пользователей и добавляет его в модель.
     *
     * @param model модель, к которой добавляется список пользователей
     * @return имя представления для отображения списка пользователей
     */
    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    /**
     * Отображает форму создания пользователя.
     *
     * @param user пустой объект пользователя
     * @return имя представления для отображения формы создания пользователя
     */
    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    /**
     * Обрабатывает отправку формы создания пользователя.
     *
     * @param user объект пользователя, отправленный через форму
     * @return перенаправление на страницу списка пользователей после создания пользователя
     */
    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * Удаляет пользователя по его ID.
     *
     * @param id ID пользователя для удаления
     * @return перенаправление на страницу списка пользователей после удаления пользователя
     */
    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}