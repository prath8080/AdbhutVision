package com.app.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer")
@Getter
@Setter
@ToString
public class Customer {

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
    @Size(max = 10,min=10, message = "Phone number must be less than 10 characters")
    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @NotBlank(message = "Gender is mandatory")
    @Size(max = 10, message = "Gender must be less than 10 characters")
    @Column(nullable = false, length = 10)
    private String gender;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters")
    @Column(nullable = false, length = 100)
    private String password; // Remember to use secure password hashing for storage

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    
    
    
}
