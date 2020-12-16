package com.flameshine.app.entity;

import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Data;

/**
 * @author Anton Pokhyla
 */

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name",unique = true, nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "quantity", nullable = false)
    @Min(value = 0, message = "Quantity cannot be less than zero.")
    private Integer quantity;

    @Column(name = "price", nullable = false)
    @DecimalMin(value = "0.00", message = "Price cannot be less than zero.")
    private BigDecimal price;
}