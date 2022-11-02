package com.deliverysystem.dispatchsystem.repository.exception;

public class RestaurantNotFoundException extends Exception {
  public RestaurantNotFoundException(final String message) {
    super(message);
  }
}
