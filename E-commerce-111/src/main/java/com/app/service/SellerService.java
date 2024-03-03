package com.app.service;

import com.app.pojo.Seller;
import com.app.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Optional<Seller> getSellerById(Long id) {
        return sellerRepository.findById(id);
    }

    public Seller createSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public Optional<Seller> updateSeller(Long id, Seller seller) {
        if (!sellerRepository.existsById(id)) {
            return Optional.empty();
        }
        seller.setId(id); // Ensure the ID matches the path variable ID
        return Optional.of(sellerRepository.save(seller));
    }

    public boolean deleteSeller(Long id) {
        if (!sellerRepository.existsById(id)) {
            return false;
        }
        sellerRepository.deleteById(id);
        return true;
    }

    // Add more methods as needed

}
