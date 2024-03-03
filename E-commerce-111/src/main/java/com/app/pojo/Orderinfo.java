package com.app.pojo;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "order_info")
@Getter
@Setter
@ToString
public class Orderinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Customer is mandatory")
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @NotBlank(message = "Address is mandatory")
    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @NotBlank(message = "Status is mandatory")
    @Size(max = 20, message = "Status must be less than 20 characters")
    @Column(nullable = false, length = 20)
    private OrderStatus status ; // e.g., PENDING, PLACED, SHIPPED, DELIVERED, CANCELLED

    @DecimalMin(value = "0.00", message = "Total amount must be non-negative")
    @Column(nullable = false)
    private double totalAmount;

    @Column(nullable = false)
    private LocalDate orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    // Getters, setters, and other methods (omitted for brevity)

}
