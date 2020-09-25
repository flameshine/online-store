package com.flameshine.app.utilitity;

import org.springframework.data.domain.Page;
import com.flameshine.app.entity.Product;

/**
 * @author Anton Pokhyla
 */

public class Pager {

    private final Page<Product> products;

    public Pager(Page<Product> products) {
        this.products = products;
    }

    public int getPageIndex() {
        return products.getNumber() + 1;
    }

    public boolean hasNext() {
        return products.hasNext();
    }

    public boolean hasPrevious() {
        return products.hasPrevious();
    }

    public int getTotalPages() {
        return products.getTotalPages();
    }

    public long getTotalElements() {
        return products.getTotalElements();
    }

    public boolean isIndexOutOfBounds() {
        return getPageIndex() < 0 || getPageIndex() > getTotalElements();
    }
}