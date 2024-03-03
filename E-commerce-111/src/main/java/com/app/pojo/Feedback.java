package com.app.pojo;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "feedback")
@Getter
@Setter
@ToString
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Min(1)
    @Max(5)
    @Column(nullable = false)
    private int rating;

    @NotBlank(message = "Comment is mandatory")
    @Size(max = 1000, message = "Comment must be less than 1000 characters")
    @Column(nullable = false, length = 1000)
    private String comment;

    // Getters, setters, and other methods (omitted for brevity)

}
