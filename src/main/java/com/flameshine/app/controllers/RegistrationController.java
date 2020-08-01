package com.flameshine.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import com.flameshine.app.services.UserService;
import com.flameshine.app.entities.User;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView("/registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView registration(@Valid User user, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView("/registration");

        if (userService.findByEmail(user.getEmail()).isPresent())
            bindingResult.rejectValue("email", "error.user", "This email is already taken.");

        if (userService.findByUsername(user.getUsername()).isPresent())
            bindingResult.rejectValue("username", "error.user", "This username is already taken.");

        if (!bindingResult.hasErrors()) {
            userService.save(user);
            modelAndView.addObject("message", "User has been registered successfully!");
            modelAndView.addObject("user", new User());
        }

        return modelAndView;
    }
}