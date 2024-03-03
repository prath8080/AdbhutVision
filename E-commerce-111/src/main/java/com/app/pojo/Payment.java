package com.app.pojo;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "payment")
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DecimalMin(value = "0.00", message = "Amount must be non-negative")
    @Column(nullable = false)
    private double amount;

    @NotBlank(message = "Payment method is mandatory")
    @Size(max = 255, message = "Payment method must be less than 255 characters")
    @Column(nullable = false, length = 255)
    private String method;

    @NotBlank(message = "Transaction ID is mandatory")
    @Size(max = 255, message = "Transaction ID must be less than 255 characters")
    @Column(nullable = false, length = 255, unique = true)
    private String transactionId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orderinfo orderinfo;

    // Getters, setters, and other methods (omitted for brevity)

}
