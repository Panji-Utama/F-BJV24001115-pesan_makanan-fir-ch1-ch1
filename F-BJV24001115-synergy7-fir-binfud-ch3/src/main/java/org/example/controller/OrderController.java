package org.example.controller;

import org.example.model.entity.Order;
import org.example.service.OrderService;
import org.example.view.MenuView;

import java.util.UUID;

public class OrderController {

    private final OrderService orderService;
    private final MenuView menuView;

    public OrderController(OrderService orderService, MenuView menuView) {
        this.orderService = orderService;
        this.menuView = menuView;
    }

    public void createOrder(UUID userId, String address) {
        orderService.createOrder(userId, address);
        menuView.displayOrderConfirmation();
    }

    public void completeOrder(UUID orderId) {
        orderService.completeOrder(orderId);
        menuView.displayOrderCompletion();
    }
}
