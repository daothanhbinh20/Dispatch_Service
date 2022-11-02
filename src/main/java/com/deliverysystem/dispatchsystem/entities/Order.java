package com.deliverysystem.dispatchsystem.entities;

import java.util.List;

public class Order {
    private int orderId;
    private int restaurantId;
    private int dishes;
    private String orderStatus;

    public Order(int orderId, int restaurantId, int dishes, String orderStatus) {
        this.orderId = orderId;
        this.restaurantId = restaurantId;
        this.dishes = dishes;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getDishes() {
        return dishes;
    }

    public void setDishes(int dishes) {
        this.dishes = dishes;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
