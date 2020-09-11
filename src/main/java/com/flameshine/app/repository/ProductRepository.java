package com.flameshine.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import com.flameshine.app.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(@Param(value = "id") Long id);
}