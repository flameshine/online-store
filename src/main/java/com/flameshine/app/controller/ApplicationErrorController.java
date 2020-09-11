package com.flameshine.app.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.*;

@RestController
public class ApplicationErrorController implements ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationErrorController.class);

    @RequestMapping(value = "/error")
    public ModelAndView error() {
        logger.info("An error occurred on the server.");
        return new ModelAndView("/error");
    }

    @GetMapping(value = "/403")
    public ModelAndView accessDeniedError() {
        logger.info("Someone tried to access a forbidden page.");
        return new ModelAndView("/403");
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}