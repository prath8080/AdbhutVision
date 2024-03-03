package com.app.controller;

import com.app.pojo.Orderinfo;
import com.app.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orderInfos")
public class OrderInfoController {

    private final OrderInfoService orderInfoService;

    @Autowired
    public OrderInfoController(OrderInfoService orderInfoService) {
        this.orderInfoService = orderInfoService;
    }

    @GetMapping
    public List<Orderinfo> getAllOrderInfos() {
        return orderInfoService.getAllOrderInfos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orderinfo> getOrderInfoById(@PathVariable Long id) {
        Optional<Orderinfo> orderInfo = orderInfoService.getOrderInfoById(id);
        return orderInfo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Orderinfo> createOrderInfo(@RequestBody Orderinfo orderInfo) {
        Orderinfo newOrderInfo = orderInfoService.createOrderInfo(orderInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrderInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orderinfo> updateOrderInfo(@PathVariable Long id, @RequestBody Orderinfo orderInfo) {
        Optional<Orderinfo> updatedOrderInfo = orderInfoService.updateOrderInfo(id, orderInfo);
        return updatedOrderInfo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderInfo(@PathVariable Long id) {
        boolean deleted = orderInfoService.deleteOrderInfo(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
