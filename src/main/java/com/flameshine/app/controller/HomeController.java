package com.flameshine.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.*;
import java.util.Optional;
import org.slf4j.*;
import com.flameshine.app.service.ProductService;
import com.flameshine.app.utilitity.Pager;
import com.flameshine.app.entity.Product;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private final ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = {"/", "/home"})
    public ModelAndView home(@RequestParam("page") Optional<Integer> page) {

        ModelAndView modelAndView = new ModelAndView("/home");

        int evaluation = (page.orElse(0) < 1) ? 0 : page.get() - 1;

        Page<Product> products = productService.findAllPageableProducts(new PageRequest(evaluation, 5));

        modelAndView.addObject("products", products);
        modelAndView.addObject("pager", new Pager(products));

        return modelAndView;
    }

    @GetMapping(value = "/home/delete/{id}")
    public String deleteProductFromList(@PathVariable("id") Long id) {
        productService.findById(id).ifPresent(x -> productService.deleteById(id));
        logger.info("Project with id " + id + "was deleted from the store.");
        return "redirect:/home";
    }
}