package com.stg.service;

import java.util.List;
import java.util.Set;

import com.stg.entity.Address;
import com.stg.entity.Dish;
import com.stg.entity.Restaurant;

public interface RestaurantServices {
	
	
	
	public Restaurant restaurantLogin(int RestaurantId, String RestaurantPassword);

	public Restaurant restaurantSignUp(int restaurantId, String restaurantName, String restaurantPassword); // create

	public Restaurant updateRestaurant(Restaurant restaurant); // update

	public Restaurant readRestaurant(int restaurantId, String restaurantPassword); // read
	public List<Restaurant> getAllRestaurants(); 	// read all restaurants

	public String deleteRestaurant(int restaurantId,  String restaurantPassword); // delete

	
	
	//Dishes 
	public List<Dish> addDishes(Dish dish) ;

	public Dish UpdateDish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable,
			Boolean vegeterianType, int restaurantId);

	public Dish createDish(Dish dish);

	public String deleteDish(int dishId);

	public Dish updateDishQuantity(int quantity, int dishId);

	public Dish readDish(int Dishid);
	
	public Set<Dish> getAllDishes(int restaurantId);

}
