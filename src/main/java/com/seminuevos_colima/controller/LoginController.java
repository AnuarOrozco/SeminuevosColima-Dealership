package com.seminuevos_colima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/home")
    String home() {
        return "home";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

}
