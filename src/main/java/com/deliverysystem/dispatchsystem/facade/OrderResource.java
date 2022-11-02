package com.deliverysystem.dispatchsystem.facade;

import com.deliverysystem.dispatchsystem.entities.Order;
import com.deliverysystem.dispatchsystem.repository.exception.RestaurantNotFoundException;
import com.deliverysystem.dispatchsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "order")
public class OrderResource {

  private final OrderService orderService;

  @Autowired
  public OrderResource(final OrderService orderService) {
    this.orderService = orderService;
  }


  @PostMapping("/")
  public ResponseEntity<String> createOrder(@RequestBody Order order) {
    int orderId = order.getOrderId();
    int restaurantId = order.getRestaurantId();
    try {
      orderService.createOrder(order);
      return ResponseEntity.status(HttpStatus.CREATED).body("Created an Order with id: " + orderId);
    } catch (RestaurantNotFoundException ex) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to find restaurant of ID: " + restaurantId);
    }
  }
}
