package com.deliverysystem.dispatchsystem.repository;

import com.deliverysystem.dispatchsystem.entities.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRepository {
    List<Order> cachedData = new ArrayList<Order>();

    public void createOrder(Order order) {
        cachedData.add(order);
    }
}
