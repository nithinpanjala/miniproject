package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	Restaurant findByRestaurantIdAndRestaurantPassword(int restaurantId , String restaurantPassword);
}
