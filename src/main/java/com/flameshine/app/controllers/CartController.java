package com.flameshine.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.flameshine.app.exceptions.NotEnoughProductsInStockException;
import com.flameshine.app.services.*;

@Controller
public class CartController {

    private final CartService cartService;

    private final ProductService productService;

    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping(value = "/cart")
    public ModelAndView cart() {
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("products", cartService.getCartProducts());
        modelAndView.addObject("totalValue", cartService.getTotal().toString());
        return modelAndView;
    }

    @GetMapping(value = "/cart/add/{id}")
    public ModelAndView addProductToCart(@PathVariable("id") Long id) {
        productService.findById(id).ifPresent(cartService::add);
        return cart();
    }

    @GetMapping(value = "/cart/remove/{id}")
    public ModelAndView removeProductFromCart(@PathVariable("id") Long id) {
        productService.findById(id).ifPresent(cartService::remove);
        return cart();
    }

    @GetMapping(value = "/cart/checkout")
    public ModelAndView checkout() {

        try {
            cartService.checkout();
        } catch (NotEnoughProductsInStockException exception) {
            return cart().addObject("notEnoughProductsInTheStockMessage", exception.getMessage());
        }

        return cart();
    }
}