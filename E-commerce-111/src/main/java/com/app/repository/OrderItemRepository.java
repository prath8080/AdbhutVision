package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<com.app.pojo.OrderItem, Long> {

}
