package com.retail.DB1.model.repository;


import com.retail.DB1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllOrdersByAccount(String name);

    List<Order> findAll();
}