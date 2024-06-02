package com.example.FBJV24001115synergy7firbinfudch5.service;

import com.example.FBJV24001115synergy7firbinfudch5.model.dto.OrdersDTO;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.OrderDetail;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Orders;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Product;
import com.example.FBJV24001115synergy7firbinfudch5.repository.OrderDetailRepository;
import com.example.FBJV24001115synergy7firbinfudch5.repository.OrderRepository;
import com.example.FBJV24001115synergy7firbinfudch5.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrdersDTO createOrder(Orders order) {
        order.setOrderTime(new Date());

        for (OrderDetail detail : order.getOrderDetails()) {
            Product product = productRepository.findById(detail.getProduct().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Product not found"));

            detail.setOrder(order);
            detail.setTotalPrice(BigDecimal.valueOf(detail.getQuantity()).multiply(BigDecimal.valueOf(product.getPrice())));
        }

        Orders savedOrder = orderRepository.save(order);
        orderDetailRepository.saveAll(order.getOrderDetails());

        return modelMapper.map(savedOrder, OrdersDTO.class);
    }

    @Override
    public List<OrdersDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> modelMapper.map(order, OrdersDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrdersDTO getOrderById(UUID id) {
        Orders order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        return modelMapper.map(order, OrdersDTO.class);
    }
}
