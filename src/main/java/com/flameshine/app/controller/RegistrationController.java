package com.flameshine.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import org.slf4j.*;

import com.flameshine.app.service.UserService;
import com.flameshine.app.entity.User;

/**
 * @author Anton Pokhyla
 */

@Controller
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/registration")
    public ModelAndView registration() {

        final ModelAndView modelAndView = new ModelAndView("/registration");

        modelAndView.addObject("user", new User());

        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView registration(@Valid User user, BindingResult bindingResult) {

        final ModelAndView modelAndView = new ModelAndView("/registration");

        final String userError = "error.user";

        if (userService.findByEmail(user.getEmail()).isPresent())
            bindingResult.rejectValue("email", userError, "This email is already taken.");

        if (userService.findByUsername(user.getUsername()).isPresent())
            bindingResult.rejectValue("username", userError, "This username is already taken.");

        if (!user.getConfirmationPassword().equals(user.getPassword()))
            bindingResult.rejectValue("confirmationPassword", userError, "Password don't match.");

        if (!bindingResult.hasErrors()) {
            userService.save(user);
            modelAndView.addObject("user", new User());
            modelAndView.addObject("message", "User has been registered successfully!");
            logger.info(user.getUsername() + "has been registered successfully.");
        }

        return modelAndView;
    }
}