package com.skovpenma.projectmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class AuthController {

    /*
    @PostMapping("/login")
    public String login(String username, String password) {
        // Перевірка введеного ім'я користувача та пароля і виконання аутентифікації
        // Перенаправлення на відповідну сторінку

        return "redirect:/hello"; // Приклад: перенаправлення на сторінку інформації про користувача
    }
    */

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Ім'я файлу HTML без розширення
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
}
