package com.app.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 255, message = "Name must be less than 255 characters")
    @Column(nullable = false, length = 255, unique = true)
    private String name;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//    private List<Product> products;

    // Getters, setters, and other methods (omitted for brevity)

}
