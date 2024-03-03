package com.app.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 255, message = "Name must be less than 255 characters")
    @Column(nullable = false, length = 255)
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Column(nullable = false, length = 1000)
    private String description;

    @DecimalMin(value = "-12.00", inclusive = false)
    @DecimalMax(value = "6.00", inclusive = false)
    @Digits(integer = 2, fraction = 2)
    private float leftEyeNumber;
    
    @DecimalMin(value = "-12.00", inclusive = false)
    @DecimalMax(value = "6.00", inclusive = false)
    @Digits(integer = 2, fraction = 2)
    private float rightEyeNumber;
    
    @DecimalMin(value = "0.00", message = "Price must be non-negative")
    @Column(nullable = false)
    private double price;

    @NotBlank(message = "Category is mandatory")
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;

//    @Column(nullable = false)
//    private byte[] images; // Byte array for storing images
//
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    private List<Feedback> feedbacks;
//
//    // Getters, setters, and other methods (omitted for brevity)
//
//    public static byte[] convertImageToByteArray(String imagePath) throws IOException {
//        File file = new File(imagePath);
//        try (FileInputStream fis = new FileInputStream(file); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
//            byte[] buf = new byte[1024];
//            for (int readNum; (readNum = fis.read(buf)) != -1; ) {
//                bos.write(buf, 0, readNum); //no doubt here is 0
//            }
//            return bos.toByteArray();
//        }
//    }
//
//    public void setImagesFromPath(String imagePath) throws IOException {
//        this.images = convertImageToByteArray(imagePath);
//    }
}
