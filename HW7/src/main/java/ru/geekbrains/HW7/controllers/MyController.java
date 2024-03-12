package ru.geekbrains.HW7.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String home(){
        return "home_page"; // Возвращается домашняя страница для всех пользователей
    }

    @GetMapping("/public-data")
    public String userPage(){
        return "public_page"; // Возвращается страница для пользователей с ролью USER и ADMIN
    }

    @GetMapping("/private-data")
    public String adminPage(){
        return "private_page"; // Возвращается страница для пользователей с ролью ADMIN
    }

    @GetMapping("/login")
    public String auth(){
        return "login_page"; // Возвращается страница аутентификации
    }
}