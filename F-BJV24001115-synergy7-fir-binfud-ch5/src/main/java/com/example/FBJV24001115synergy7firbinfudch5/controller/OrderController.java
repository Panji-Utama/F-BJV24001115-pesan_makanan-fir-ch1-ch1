package com.example.FBJV24001115synergy7firbinfudch5.controller;

import com.example.FBJV24001115synergy7firbinfudch5.model.dto.OrdersDTO;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Orders;
import com.example.FBJV24001115synergy7firbinfudch5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrdersDTO> createOrder(@RequestBody Orders order) {
        OrdersDTO createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping
    public ResponseEntity<List<OrdersDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdersDTO> getOrderById(@PathVariable UUID id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
}
