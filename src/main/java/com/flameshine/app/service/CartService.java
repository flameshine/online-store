package com.flameshine.app.service;

import java.util.Map;
import java.math.BigDecimal;

import com.flameshine.app.exception.NotEnoughProductsInStockException;
import com.flameshine.app.entity.Product;

/**
 * @author Anton Pokhyla
 */

public interface CartService {

    void add(Product product);

    void remove(Product product);

    void checkout() throws NotEnoughProductsInStockException;

    BigDecimal getTotal();

    Map<Product, Integer> getCartProducts();
}