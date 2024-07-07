package com.example.FBJV24001115synergy7firbinfudch6.controller;

import com.example.FBJV24001115synergy7firbinfudch6.model.dto.UpdateUserAndOrdersDTO;
import com.example.FBJV24001115synergy7firbinfudch6.model.entity.Orders;
import com.example.FBJV24001115synergy7firbinfudch6.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order) {
        Orders createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable UUID id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PatchMapping("/updateUserAndOrders")
    public ResponseEntity<?> updateUserAndOrders(@Valid @RequestBody UpdateUserAndOrdersDTO request) {
        orderService.updateUserAndOrders(request.getUserId(), request.getNewEmail(), request.getNewAddress());
        return ResponseEntity.ok("User email and orders' addresses updated successfully.");
    }
}