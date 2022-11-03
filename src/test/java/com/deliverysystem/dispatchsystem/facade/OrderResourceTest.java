package com.deliverysystem.dispatchsystem.facade;

import com.deliverysystem.dispatchsystem.entities.Order;
import com.deliverysystem.dispatchsystem.repository.exception.RestaurantNotFoundException;
import com.deliverysystem.dispatchsystem.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OrderResourceTest {
  private static final int ORDER_ID = 1;
  private static final int RESTAURANT_ID = 2;
  private static final int DISHES = 10;
  private static final String ORDER_STATUS = "Preparing";

  private OrderResource orderResource;
  private OrderService orderService;

  @BeforeEach
  public void setUp() {
    orderService = mock(OrderService.class);
    orderResource = new OrderResource(orderService);
  }

  @Test
  public void createOrder_returnCreatedStatus_Successful() throws RestaurantNotFoundException {
    Order order = new Order(ORDER_ID, RESTAURANT_ID, DISHES, ORDER_STATUS);
    doNothing().when(orderService).createOrder(order);

    ResponseEntity responseEntity = orderResource.createOrder(order);
    assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    verify(orderService).createOrder(order);
  }

  @Test
  public void createOrder_returnNotFoundStatus_Successful() throws RestaurantNotFoundException {
    Order order = new Order(ORDER_ID, RESTAURANT_ID, DISHES, ORDER_STATUS);
    doThrow(new RestaurantNotFoundException("")).when(orderService).createOrder(order);

    ResponseEntity responseEntity = orderResource.createOrder(order);
    assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
    verify(orderService).createOrder(order);
  }
}
