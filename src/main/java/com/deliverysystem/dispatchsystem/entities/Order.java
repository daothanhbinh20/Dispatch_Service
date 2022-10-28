package com.deliverysystem.dispatchsystem.entities;

public class Order {
    private final int orderId;
    private Restaurant restaurant;
    private int dish;
    private Address destination;

    public Order(final int orderId) {
        this.orderId = orderId;
    }
}
