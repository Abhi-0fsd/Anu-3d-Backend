package com._d.Anu3dprints.controller;


import com._d.Anu3dprints.entity.Order;
import com._d.Anu3dprints.service.OrderService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(
            @RequestBody Order order,
            Authentication authentication) {

        String email = authentication.getName();

        return ResponseEntity.ok(
                orderService.placeOrder(
                        email,
                        order
                )
        );
    }

    @GetMapping("/my")
    public ResponseEntity<List<Order>> myOrders(
            Authentication authentication) {

        String email = authentication.getName();

        return ResponseEntity.ok(
                orderService.getMyOrders(email)
        );
    }
}
