package com.app.service;

import com.app.pojo.Category;
import com.app.pojo.Product;
import com.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContaining(name);
    }

    public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice) {
        return productRepository.findByPriceRange(minPrice, maxPrice);
    }

    public List<Product> getProductsByRatingGreaterThan(Integer rating) {
        return productRepository.findByRatingGreaterThan(rating);
    }

    public List<Product> getLatestProducts(int n) {
        return productRepository.findLatestProducts(n);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> updateProduct(Long id, Product product) {
        if (!productRepository.existsById(id)) {
            return Optional.empty();
        }
        product.setId(id); // Ensure the ID matches the path variable ID
        return Optional.of(productRepository.save(product));
    }

    public boolean deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

    // Add more methods as needed

}
