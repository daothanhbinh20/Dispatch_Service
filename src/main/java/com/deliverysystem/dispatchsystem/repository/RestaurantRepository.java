package com.deliverysystem.dispatchsystem.repository;

import com.deliverysystem.dispatchsystem.repository.exception.RestaurantNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class RestaurantRepository {

    public void verifyRestaurantExists(final int restaurantId) throws RestaurantNotFoundException {

    }
}
