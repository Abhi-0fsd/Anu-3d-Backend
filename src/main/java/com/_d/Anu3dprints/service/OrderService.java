package com._d.Anu3dprints.service;


import com._d.Anu3dprints.entity.Order;
import com._d.Anu3dprints.entity.User;
import com._d.Anu3dprints.repository.OrderRepository;
import com._d.Anu3dprints.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(
            OrderRepository orderRepository,
            UserRepository userRepository) {

        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public Order placeOrder(
            String email,
            Order order) {

        User user =
                userRepository
                        .findByEmail(email)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "User not found"
                                )
                        );

        order.setUser(user);

        return orderRepository.save(order);
    }

    public List<Order> getMyOrders(
            String email) {

        User user =
                userRepository
                        .findByEmail(email)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "User not found"
                                )
                        );

        return orderRepository.findByUser(user);
    }
}