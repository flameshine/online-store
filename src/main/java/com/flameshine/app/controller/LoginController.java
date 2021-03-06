package com.flameshine.app.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.*;

/**
 * @author Anton Pokhyla
 */

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping(value = "/login")
    public String login(Principal principal) {

        if (principal != null) {
            logger.info(principal.getName() + " is successfully logged in.");
            return "redirect:/home";
        }

        return "/login";
    }
}