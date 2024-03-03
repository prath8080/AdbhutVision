package com.app.service;

import com.app.pojo.OrderItem;
import com.app.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

//    public Optional<OrderItem> updateOrderItem(Long id, OrderItem orderItem) {
//        if (!orderItemRepository.existsById(id)) {
//            return Optional.empty();
//        }
//        orderItem.setId(id); // Ensure the ID matches the path variable ID
//        return Optional.of(orderItemRepository.save(orderItem));
//    }

    public boolean deleteOrderItem(Long id) {
        if (!orderItemRepository.existsById(id)) {
            return false;
        }
        orderItemRepository.deleteById(id);
        return true;
    }

}
