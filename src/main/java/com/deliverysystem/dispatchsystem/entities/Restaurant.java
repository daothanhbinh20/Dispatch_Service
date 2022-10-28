package com.deliverysystem.dispatchsystem.entities;

public class Restaurant {
  private final int restaurantId;
  private final String name;
  private final Address location;

  public Restaurant(final int restaurantId, final String name, final Address location) {
    this.restaurantId = restaurantId;
    this.name = name;
    this.location = location;
  }
}
