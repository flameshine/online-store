package com.flameshine.app.services;

import java.math.BigDecimal;
import java.util.Map;
import com.flameshine.app.exceptions.NotEnoughProductsInStockException;
import com.flameshine.app.entities.Product;

public interface CartService {

    void add(Product product);

    void remove(Product product);

    void checkout() throws NotEnoughProductsInStockException;

    BigDecimal getTotal();

    Map<Product, Integer> getCartProducts();
}