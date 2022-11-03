package com.deliverysystem.dispatchsystem.service;

import com.deliverysystem.dispatchsystem.entities.Order;
import com.deliverysystem.dispatchsystem.repository.OrderRepository;
import com.deliverysystem.dispatchsystem.repository.RestaurantRepository;
import com.deliverysystem.dispatchsystem.repository.exception.RestaurantNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class OrderServiceTest {
  private static final int ORDER_ID = 1;
  private static final int RESTAURANT_ID = 2;
  private static final int DISHES = 10;
  private static final String ORDER_STATUS = "Preparing";
  private OrderService orderService;
  private OrderRepository orderRepository;
  private RestaurantRepository restaurantRepository;

  @BeforeEach
  public void setUp() {
    orderRepository = mock(OrderRepository.class);
    restaurantRepository = mock(RestaurantRepository.class);
    orderService = new OrderService(orderRepository, restaurantRepository);
  }

  @Test
  public void createOrder_Successful() throws RestaurantNotFoundException {
    Order order = new Order(ORDER_ID, RESTAURANT_ID, DISHES, ORDER_STATUS);
    doNothing().when(restaurantRepository).verifyRestaurantExists(order.getRestaurantId());
    doNothing().when(orderRepository).createOrder(order);

    orderService.createOrder(order);
    verify(orderRepository).createOrder(order);
    verify(restaurantRepository).verifyRestaurantExists(order.getRestaurantId());
  }

  @Test
  public void createOrder_throwsRestaurantNotFoundException_Successful()
      throws RestaurantNotFoundException {
    Order order = new Order(ORDER_ID, RESTAURANT_ID, DISHES, ORDER_STATUS);
    doThrow(new RestaurantNotFoundException(""))
        .when(restaurantRepository)
        .verifyRestaurantExists(order.getRestaurantId());

    assertThrows(RestaurantNotFoundException.class, () -> orderService.createOrder(order));

    verify(orderRepository, never()).createOrder(order);
    verify(restaurantRepository).verifyRestaurantExists(order.getRestaurantId());
  }
}
