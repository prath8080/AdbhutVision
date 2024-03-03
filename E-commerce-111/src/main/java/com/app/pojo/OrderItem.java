package com.app.pojo;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orderinfo order;

    @NotBlank(message = "Product is mandatory")
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Min(1)
    @Column(nullable = false)
    private int quantity;

    @DecimalMin(value = "0.00", message = "Price must be non-negative")
    @Column(nullable = false)
    private double price;

    // Getters, setters, and other methods (omitted for brevity)

}
