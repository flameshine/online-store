package com.flameshine.app.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ApplicationErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public ModelAndView error() {
        return new ModelAndView("/error");
    }

    @GetMapping(value = "/403")
    public ModelAndView accessDeniedError() {
        return new ModelAndView("/403");
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}