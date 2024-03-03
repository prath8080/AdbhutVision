package com.app.service;

import com.app.pojo.Orderinfo;
import com.app.repository.OrderInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderInfoService {

    private final OrderInfoRepository orderInfoRepository;

    @Autowired
    public OrderInfoService(OrderInfoRepository orderInfoRepository) {
        this.orderInfoRepository = orderInfoRepository;
    }

    public List<Orderinfo> getAllOrderInfos() {
        return orderInfoRepository.findAll();
    }

    public Optional<Orderinfo> getOrderInfoById(Long id) {
        return orderInfoRepository.findById(id);
    }

    public Orderinfo createOrderInfo(Orderinfo orderInfo) {
        return orderInfoRepository.save(orderInfo);
    }

    public Optional<Orderinfo> updateOrderInfo(Long id, Orderinfo orderInfo) {
        if (!orderInfoRepository.existsById(id)) {
            return Optional.empty();
        }
        orderInfo.setId(id); // Ensure the ID matches the path variable ID
        return Optional.of(orderInfoRepository.save(orderInfo));
    }

    public boolean deleteOrderInfo(Long id) {
        if (!orderInfoRepository.existsById(id)) {
            return false;
        }
        orderInfoRepository.deleteById(id);
        return true;
    }

}
