package com.stg.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.Address;
import com.stg.entity.Dish;
import com.stg.entity.Restaurant;
import com.stg.repository.DishRepository;
import com.stg.repository.RestaurantRepository;

@Service
public class RestaurantServicesImpl implements RestaurantServices {

	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	DishRepository dishRepository;
	
	@Override
	public Restaurant restaurantLogin(int RestaurantId, String RestaurantPassword) {
		return restaurantRepository.findByRestaurantIdAndRestaurantPassword(RestaurantId, RestaurantPassword);
	}

	@Override
	public List<Restaurant> getAllRestaurants(){
		return restaurantRepository.findAll();

	}


	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant readRestaurant(int restaurantId, String restaurantPassword) {
		return restaurantRepository.findByRestaurantIdAndRestaurantPassword(restaurantId, restaurantPassword);
	}

	@Override
	public String deleteRestaurant(int restaurantId, String restaurantPassword) {
		// TODO Auto-generated method stub
		Restaurant restaurant= restaurantRepository.findByRestaurantIdAndRestaurantPassword(restaurantId, restaurantPassword);
		if(restaurant == null) {
			return "invalid restaurant id and password";
		}
		else {
		restaurantRepository.delete(restaurant);
		return "Restaurant " + restaurant.getRestaurantName()+ " is deleted ";
		}
	}



	@Override
	public Restaurant restaurantSignUp(int restaurantId, String restaurantName, String restaurantPassword) {
		Restaurant restaurant = new Restaurant(restaurantId, restaurantName, restaurantPassword);
		return restaurantRepository.save(restaurant);
	}



	@Override
	public List<Dish> addDishes(Dish dish) {
		dishRepository.save(dish);
		return dishRepository.findAll();
	}



	@Override
	public Dish UpdateDish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable,
			Boolean vegeterianType, int restaurantId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Dish createDish(Dish dish) {
		return dishRepository.save(dish);
	
	}



	@Override
	public String deleteDish(int dishId) {
		dishRepository.delete(dishRepository.getById(dishId));
		return " dishID" + dishId+ "deleted";
	}



	@Override
	public Dish updateDishQuantity(int quantity, int dishId) {
		Dish dish = dishRepository.findById(dishId).get();
		dish.setDishQuantityAvailable(quantity);
		dishRepository.save(dish);
		return dish;
	}



	@Override
	public Dish readDish(int dishId) {
		return dishRepository.findById(dishId).get();
	}
	
	@Override
	public Set<Dish> getAllDishes(int restaurantId){
		Restaurant restaurant =  restaurantRepository.findById(restaurantId).get();
		return restaurant.getDishes();
	}
}
