package com.flameshine.app.service;

import java.util.Optional;

import org.springframework.data.domain.*;

import com.flameshine.app.entity.Product;

/**
 * @author Anton Pokhyla
 */

public interface ProductService {

    void deleteById(Long id);

    Optional<Product> findById(Long id);

    Page<Product> findAllPageableProducts(Pageable pageable);
}