package com.flameshine.app.service.implementation;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.*;

import com.flameshine.app.repository.ProductRepository;
import com.flameshine.app.service.ProductService;
import com.flameshine.app.entity.Product;

/**
 * @author Anton Pokhyla
 */

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
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