package com.stg.service;

import java.util.List;
import java.util.Set;

import com.stg.entity.Address;
import com.stg.entity.Dish;
import com.stg.entity.Dish.FoodType;
import com.stg.exceptions.CustomException;
import com.stg.entity.Restaurant;
import com.stg.entity.User;

public interface RestaurantServices {
	
	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */

	public Restaurant restaurantSignUp(int restaurantId, String restaurantName)throws CustomException; // create
	public Restaurant addAddress(Address address) throws CustomException;
	public Restaurant  addRestaurantAddress( String houseNumber, String addressLane1, String addressLane2, String landmark,
			int pincode, String district, String state, int restautantId) throws CustomException;
	
	/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */
	public Restaurant readRestaurant(int restaurantId)throws CustomException; // read
	public List<Restaurant> getAllRestaurants()throws CustomException; 	// read all restaurants
	
	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */
	public Restaurant updateRestaurant(Restaurant restaurant)throws CustomException; // update
	
	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */
	public String deleteRestaurant(int restaurantId)throws CustomException; // delete
	
	
	//Dishes 
	public List<Dish> addDishes(Dish dish) throws CustomException;

	public Dish UpdateDish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable,
			FoodType vegeterianType, int restaurantId)throws CustomException;

	public Dish createDish(Dish dish)throws CustomException;

	public String deleteDish(int dishId)throws CustomException;

	public Dish updateDishQuantity(int quantity, int dishId)throws CustomException;

	public Dish readDish(int Dishid)throws CustomException;
	
	public Set<Dish> getAllDishes(int restaurantId)throws CustomException;

}
