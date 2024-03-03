package com.app.DTO;

import com.app.pojo.Category;
import com.app.pojo.Seller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Getter
@Setter
public class ProductDTO {

    @NotBlank(message = "Name is mandatory")
    @Size(max = 255, message = "Name must be less than 255 characters")
    private String name;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @DecimalMin(value = "-12.00", inclusive = false)
    @DecimalMax(value = "6.00", inclusive = false)
    private float leftEyeNumber;

    @DecimalMin(value = "-12.00", inclusive = false)
    @DecimalMax(value = "6.00", inclusive = false)
    private float rightEyeNumber;

    @DecimalMin(value = "0.00", message = "Price must be non-negative")
    private double price;

    @NotBlank(message = "Category is mandatory")
    private Category category;

    @NotBlank(message = "Seller is mandatory")
    private Seller seller;

    
}
