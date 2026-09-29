package com._d.Anu3dprints.repository;


import com._d.Anu3dprints.entity.Order;
import com._d.Anu3dprints.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);
}
