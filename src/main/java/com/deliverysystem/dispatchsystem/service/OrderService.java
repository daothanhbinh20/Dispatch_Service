package com.deliverysystem.dispatchsystem.service;

import com.deliverysystem.dispatchsystem.entities.Order;
import com.deliverysystem.dispatchsystem.repository.OrderRepository;
import com.deliverysystem.dispatchsystem.repository.RestaurantRepository;
import com.deliverysystem.dispatchsystem.repository.exception.RestaurantNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
  private final OrderRepository orderRepository;
  private final RestaurantRepository restaurantRepository;

  @Autowired
  public OrderService(
      final OrderRepository orderRepository, final RestaurantRepository restaurantRepository) {
    this.orderRepository = orderRepository;
    this.restaurantRepository = restaurantRepository;
  }

  public void createOrder(final Order order) throws RestaurantNotFoundException {
    restaurantRepository.verifyRestaurantExists(order.getRestaurantId());
    orderRepository.createOrder(order);
  }
}
