package com.flameshine.app.services;

import org.springframework.data.domain.*;
import java.util.Optional;
import com.flameshine.app.entities.Product;

public interface ProductService {

    Optional<Product> findById(Long id);

    Page<Product> findAllPageableProducts(Pageable pageable);
}