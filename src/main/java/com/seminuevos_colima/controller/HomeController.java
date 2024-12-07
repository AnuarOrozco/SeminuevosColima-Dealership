package com.seminuevos_colima.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    public String homePage(Model model, HttpSession session) {
        String user = (String) session.getAttribute("user"); // harcodeado xD

        if (session.getAttribute("user") != null) {
            model.addAttribute("userLoggedIn", true);
        } else {
            model.addAttribute("userLoggedIn", false);
        }
        return "home";
    }

    @PostMapping("/login")
    public String loginUser(HttpSession session) {
        // falta poner las validaciones de credenciales del user
        session.setAttribute("user", "userLoggedIn");
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }


}
