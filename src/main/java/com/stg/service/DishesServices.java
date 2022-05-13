package com.stg.service;

import java.util.List;
import java.util.Set;

import com.stg.entity.Dish;
import com.stg.entity.Restaurant;
import com.stg.entity.Dish.FoodType;

public interface DishesServices {

	public Set<Dish> addDishes(Dish dish);

	public Dish UpdateDish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable,
			FoodType vegeterianType, Restaurant restaurant);

	public Dish createDish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable,
			FoodType vegeterianType, Restaurant restaurant);

	public Dish deleteDish(int dishId);

	public Dish updateDishQuantity(int quantity, int dishId);

	public Dish readDish(int DishId);

	public List<Dish> readAllDishes();



}
