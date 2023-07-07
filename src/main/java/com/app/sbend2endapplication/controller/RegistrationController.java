package com.app.sbend2endapplication.controller;

import com.app.sbend2endapplication.event.RegistrationCompleteEvent;
import com.app.sbend2endapplication.registration.RegistrationRequest;
import com.app.sbend2endapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {
    private final UserService service;

    private final ApplicationEventPublisher publisher;
    @GetMapping("/registration-form")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new RegistrationRequest());
    return "Registration";
    }

    @PostMapping("/registers")
    public String registerUser(@ModelAttribute("user") RegistrationRequest request){
        var user=service.registerUser(request);
        //here we going to the event
        publisher.publishEvent(new RegistrationCompleteEvent(user,""));
        return "redirect:/register//registration-form?success";//redirect to the registration form
    }
}
