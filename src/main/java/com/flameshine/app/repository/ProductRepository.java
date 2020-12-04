package com.flameshine.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.flameshine.app.entity.Product;

/**
 * @author Anton Pokhyla
 */

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(@Param(value = "id") Long id);
}