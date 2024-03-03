package com.app.pojo;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "seller")
@Getter
@Setter
@ToString
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 255, message = "Name must be less than 255 characters")
    @Column(nullable = false, length = 255)
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Size(max = 20, message = "Phone number must be less than 20 characters")
    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Product> products;

    // Getters, setters, and other methods (omitted for brevity)

}
