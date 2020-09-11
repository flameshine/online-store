package com.flameshine.app.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.*;
import java.util.Optional;
import com.flameshine.app.repository.ProductRepository;
import com.flameshine.app.entity.Product;

@Service
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productRepository.delete(id);
    }

    @Override
    @Transactional
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional
    public Page<Product> findAllPageableProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}