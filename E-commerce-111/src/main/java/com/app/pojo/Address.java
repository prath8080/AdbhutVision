package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "address")
@Getter
@Setter
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Street is mandatory")
    @Size(max = 255, message = "Street must be less than 255 characters")
    @Column(nullable = false, length = 255)
    private String street;

    @NotBlank(message = "City is mandatory")
    @Size(max = 255, message = "City must be less than 255 characters")
    @Column(nullable = false, length = 255)
    private String city;

    @NotBlank(message = "State is mandatory")
    @Size(max = 255, message = "State must be less than 255 characters")
    @Column(nullable = false, length = 255)
    private String state;

    @NotBlank(message = "Country is mandatory")
    @Size(max = 255, message = "Country must be less than 255 characters")
    @Column(nullable = false, length = 255)
    private String country;

    @NotBlank(message = "Postal code is mandatory")
    @Size(max = 6,min=6, message = "Postal code must be exactly 6 characters")
    @Column(nullable = false, length = 6)
    private String postalCode;

    // Getters, setters, and other methods (omitted for brevity)

}
