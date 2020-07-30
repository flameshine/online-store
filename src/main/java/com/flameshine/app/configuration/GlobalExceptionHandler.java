package com.flameshine.app.configuration;

import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView exception(final Throwable throwable, final Model model) {
        ModelAndView modelAndView = new ModelAndView("/error");
        modelAndView.addObject("errorMessage", (throwable != null ? throwable.toString() : "Unknown Error"));
        return modelAndView;
    }
}