package com.flameshine.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import com.flameshine.app.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(@Param("id") Long id);
}