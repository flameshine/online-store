package com.flameshine.app.service;

import java.math.BigDecimal;
import java.util.Map;
import com.flameshine.app.exception.NotEnoughProductsInStockException;
import com.flameshine.app.entity.Product;

public interface CartService {

    void add(Product product);

    void remove(Product product);

    void checkout() throws NotEnoughProductsInStockException;

    BigDecimal getTotal();

    Map<Product, Integer> getCartProducts();
}