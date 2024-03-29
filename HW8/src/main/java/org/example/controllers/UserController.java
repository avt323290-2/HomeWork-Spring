package org.example.controllers;

import org.example.model.User;
import org.example.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Контроллер для обработки запросов, связанных с пользователями.
 */
@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * Получает всех пользователей и отображает страницу списка пользователей.
     *
     * @param model Объект Model для добавления атрибутов для отображения представления.
     * @return Имя представления для отображения.
     */
    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    /**
     * Отображает форму для создания нового пользователя.
     *
     * @param user Пустой объект User для привязки данных формы.
     * @return Имя представления для отображения.
     */
    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    /**
     * Обрабатывает отправку формы создания пользователя.
     *
     * @param user Объект User, содержащий данные формы.
     * @return Перенаправляет на страницу списка пользователей.
     */
    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * Обрабатывает удаление пользователя.
     *
     * @param id Идентификатор пользователя для удаления.
     * @return Перенаправляет на страницу списка пользователей.
     */
    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    /**
     * Отображает форму для обновления пользователя.
     *
     * @param id    Идентификатор пользователя для обновления.
     * @param model Объект Model для добавления атрибутов для отображения представления.
     * @return Имя представления для отображения.
     */
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    /**
     * Обрабатывает отправку формы обновления пользователя.
     *
     * @param user Объект User, содержащий обновленные данные.
     * @return Перенаправляет на страницу списка пользователей.
     */
    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }
}