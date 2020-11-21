package com.flameshine.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.*;

import com.flameshine.app.exception.NotEnoughProductsInStockException;
import com.flameshine.app.service.*;

/**
 * @author Anton Pokhyla
 */

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    private final CartService cartService;

    private final ProductService productService;

    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping(value = "")
    public ModelAndView cart() {

        final ModelAndView modelAndView = new ModelAndView("/cart");

        modelAndView.addObject("products", cartService.getCartProducts());
        modelAndView.addObject("totalValue", cartService.getTotal().toString());

        return modelAndView;
    }

    @GetMapping(value = "/add/{id}")
    public ModelAndView addProductToCart(@PathVariable("id") Long id) {
        productService.findById(id).ifPresent(cartService::add);
        logger.info("Product with id " + id + "was added to the cart.");
        return cart();
    }

    @GetMapping(value = "/remove/{id}")
    public ModelAndView removeProductFromCart(@PathVariable("id") Long id) {
        productService.findById(id).ifPresent(cartService::remove);
        logger.info("Product with id " + id + "was removed from the cart.");
        return cart();
    }

    @GetMapping(value = "/checkout")
    public ModelAndView checkout() {

        try {
            cartService.checkout();
        } catch (NotEnoughProductsInStockException exception) {
            logger.error(exception.getMessage() + " occurred.");
            return cart().addObject("notEnoughProductsInTheStockMessage", exception.getMessage());
        }

        return cart();
    }
}