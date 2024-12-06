package com.seminuevos_colima.controller;

import com.seminuevos_colima.entity.User;
import com.seminuevos_colima.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user, Model model) {
        if (userService.findByEmail(user.getEmail()) != null) {
            model.addAttribute("Error", "El email ya ha sido registrado previamente");
            return "signup"; // Redirige al formulario de registro en caso de error
        }
        userService.registerUser(user); // Registra al usuario en la base de datos
        return "redirect:/login"; // Redirige al login tras un registro exitoso
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        User user = userService.findByEmail(email);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            model.addAttribute("Error", "Credenciales incorrectas");
            return "login"; // Redirige al login en caso de error
        }
        return "redirect:/home"; // Redirige al home tras login exitoso
    }

}
