package com.flameshine.app.exception;

import com.flameshine.app.entity.Product;

/**
 * @author Anton Pokhyla
 */

public class NotEnoughProductsInStockException extends Exception {

    public NotEnoughProductsInStockException() {}

    public NotEnoughProductsInStockException(Product product) {
        super(String.format("Not enough %s products in stock. Only %d left ", product.getName(), product.getQuantity()));
    }
}