package com.example.FBJV24001115synergy7firbinfudch5.service;

import com.example.FBJV24001115synergy7firbinfudch5.model.entity.OrderDetail;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Orders;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Product;
import com.example.FBJV24001115synergy7firbinfudch5.repository.OrderDetailRepository;
import com.example.FBJV24001115synergy7firbinfudch5.repository.OrderRepository;
import com.example.FBJV24001115synergy7firbinfudch5.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @Override
    public Orders createOrder(Orders order) {
        logger.info("Creating order: {}", order);
        order.setOrderTime(new Date());

        if (order.getOrderDetails() == null) {
            order.setOrderDetails(new ArrayList<>());
        }

        List<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderDetail detail : order.getOrderDetails()) {
            logger.info("Processing OrderDetail: {}", detail);
            Product product = productRepository.findById(detail.getProduct().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Product not found"));

            detail.setOrder(order);
            detail.setTotalPrice(BigDecimal.valueOf(detail.getQuantity()).multiply(BigDecimal.valueOf(product.getPrice())));
            logger.info("OrderDetail after setting order and total price: {}", detail);
            orderDetails.add(detail);
        }

        order.setOrderDetails(orderDetails);
        Orders savedOrder = orderRepository.save(order);
        logger.info("Saved order: {}", savedOrder);

        for (OrderDetail detail : orderDetails) {
            logger.info("Saving OrderDetail: {}", detail);
            orderDetailRepository.save(detail);
            logger.info("Saved OrderDetail: {}", detail);
        }

        savedOrder = orderRepository.findById(savedOrder.getId()).orElseThrow(() -> new IllegalArgumentException("Order not found after save"));
        logger.info("Saved order with details: {}", savedOrder);

        return savedOrder;
    }

    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Orders getOrderById(UUID id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }
}
