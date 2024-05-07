package com.example.FBJV24001115synergy7firbinfudch5.service;

import com.example.FBJV24001115synergy7firbinfudch5.model.entity.OrderDetail;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Orders;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Product;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Users;
import com.example.FBJV24001115synergy7firbinfudch5.repository.OrderDetailRepository;
import com.example.FBJV24001115synergy7firbinfudch5.repository.OrderRepository;
import com.example.FBJV24001115synergy7firbinfudch5.repository.ProductRepository;
import com.example.FBJV24001115synergy7firbinfudch5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Orders createOrder(String destinationAddress, UUID userId, List<OrderDetail> details) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Orders order = new Orders();
        order.setDestinationAddress(destinationAddress);
        order.setUser(user);
        order.setOrderTime(new Date());
        order.setCompleted(false);
        Orders savedOrder = orderRepository.save(order);

        details.forEach(detail -> {
            Product product = productRepository.findById(detail.getProduct().getId()).orElseThrow(() -> new RuntimeException("Product not found"));
            BigDecimal price = BigDecimal.valueOf(product.getPrice());
            detail.setOrder(savedOrder);
            detail.setTotalPrice(price.multiply(BigDecimal.valueOf(detail.getQuantity())));
            orderDetailRepository.save(detail);
        });

        return savedOrder;
    }

    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }
}
