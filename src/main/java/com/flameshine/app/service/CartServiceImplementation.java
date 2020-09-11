package com.flameshine.app.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import java.math.BigDecimal;
import java.util.*;
import com.flameshine.app.exception.NotEnoughProductsInStockException;
import com.flameshine.app.repository.ProductRepository;
import com.flameshine.app.entity.Product;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartServiceImplementation implements CartService {

    private final ProductRepository productRepository;

    private final Map<Product, Integer> products = new HashMap<>();

    @Autowired
    public CartServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void add(Product product) {

        if (products.containsKey(product))
            products.replace(product, products.get(product) + 1);
        else
            products.put(product, 1);
    }

    @Override
    public void remove(Product product) {

        if (products.containsKey(product)) {

            if (products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else if (products.get(product) == 1)
                products.remove(product);
        }
    }

    @Override
    @Transactional
    public void checkout() throws NotEnoughProductsInStockException {

        Product product;

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {

            product = productRepository.findOne(entry.getKey().getId());

            if (product.getQuantity() < entry.getValue())
                throw new NotEnoughProductsInStockException(product);

            entry.getKey().setQuantity(product.getQuantity() - entry.getValue());
        }

        productRepository.save(products.keySet());

        productRepository.flush();

        products.clear();
    }

    @Override
    public BigDecimal getTotal() {
        return products.entrySet().stream().map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue()))).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    @Override
    public Map<Product, Integer> getCartProducts() {
        return Collections.unmodifiableMap(products);
    }
}