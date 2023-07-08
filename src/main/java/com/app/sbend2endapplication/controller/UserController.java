package com.app.sbend2endapplication.controller;

import com.app.sbend2endapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    @GetMapping
    private String getUser(Model model)
    {
        model.addAttribute("users", service.getAllUsers());
        return "Users";
    }
}
