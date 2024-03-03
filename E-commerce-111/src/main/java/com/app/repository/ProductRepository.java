package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojo.*;

public interface ProductRepository extends JpaRepository<com.app.pojo.Product, Long> {

    // Find products by category
    List<Product> findByCategory(Category category);

    // Find products by name (case-insensitive)
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(:name)")
    List<Product> findByNameContaining(@Param("name") String name);

    // Find products within a price range
    @Query("SELECT p FROM Product p WHERE p.price >= :minPrice AND p.price <= :maxPrice")
    List<Product> findByPriceRange(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);

    // Find products with a rating above a certain value
    @Query("SELECT p FROM Product p WHERE p.id IN (SELECT fo.product.id FROM Feedback fo WHERE fo.rating >= :rating)")
    List<Product> findByRatingGreaterThan(@Param("rating") Integer rating);

    // Find the latest N products added
    @Query("SELECT p FROM Product p ORDER BY p.id DESC")
    List<Product> findLatestProducts(int n);

    // ... Add more custom methods as needed
}
