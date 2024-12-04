package com.seminuevos_colima.controller;

import com.seminuevos_colima.entity.User;
import com.seminuevos_colima.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user, Model model) {
        if (userService.findByEmail(user.getEmail()) != null) {
            model.addAttribute("Error", "El email ya ha sido registrado previamente");
            return "signup";
        }
        userService.registerUser(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        return "redirect:/home";
    }

}
