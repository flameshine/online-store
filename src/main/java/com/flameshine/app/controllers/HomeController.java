package com.flameshine.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.*;
import java.util.Optional;
import com.flameshine.app.services.ProductService;
import com.flameshine.app.entities.Product;
import com.flameshine.app.utilities.Pager;

@Controller
public class HomeController {

    private final ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/home")
    public ModelAndView home(@RequestParam("page") Optional<Integer> page) {

        ModelAndView modelAndView = new ModelAndView("/home");

        int evaluation = (page.orElse(0) < 1) ? 0 : page.get() - 1;

        Page<Product> products = productService.findAllPageableProducts(new PageRequest(evaluation, 5));

        modelAndView.addObject("products", products);
        modelAndView.addObject("pager", new Pager(products));

        return modelAndView;
    }
}