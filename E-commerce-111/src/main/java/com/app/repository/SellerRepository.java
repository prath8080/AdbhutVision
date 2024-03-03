package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{

}