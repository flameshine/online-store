package com.flameshine.app.exceptions;

import com.flameshine.app.entities.Product;

public class NotEnoughProductsInStockException extends Exception {

    public NotEnoughProductsInStockException() {
        super("Not enough products in stock!");
    }

    public NotEnoughProductsInStockException(Product product) {
        super(String.format("Not enough %s products in stock. Only %d left ", product.getName(), product.getQuantity()));
    }
}