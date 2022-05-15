package com.stg.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.Address;
import com.stg.entity.Dish;
import com.stg.entity.Restaurant;
import com.stg.entity.User;
import com.stg.exceptions.CustomException;
import com.stg.entity.Dish.FoodType;
import com.stg.repository.AddressRepository;
import com.stg.repository.DishRepository;
import com.stg.repository.RestaurantRepository;

@Service
public class RestaurantServicesImpl implements RestaurantServices {

	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	DishRepository dishRepository;
	@Autowired
	AddressRepository addressRepository;


	@Override
	public List<Restaurant> getAllRestaurants(){
		if(restaurantRepository.findAll().size() != 0) {
			return restaurantRepository.findAll();
		} else {
			throw new CustomException("No restaurants Found");
		}
		

	}


	@Override
	public Restaurant updateRestaurant(Restaurant restaurant)throws CustomException {
		if(restaurantRepository.findById(restaurant.getRestaurantId()).isEmpty()) {
			return restaurantRepository.save(restaurant);
		} else {
			throw new CustomException("Restaurant with Id "+ restaurant.getRestaurantId() + " already exists.");
		}
		
	}

	@Override
	public Restaurant readRestaurant(int restaurantId)throws CustomException {
		if(restaurantRepository.findById(restaurantId).isPresent()) {
			return restaurantRepository.findById(restaurantId).get();
		} else {
			throw new CustomException("Restuarant with Id "+ restaurantId + " doesnot exists.");
		}
		
	}

	@Override
	public String deleteRestaurant(int restaurantId)throws CustomException {
		
		//Restaurant restaurant= restaurantRepository.findById(restaurantId).get();
		if(restaurantRepository.findById(restaurantId).isPresent()) {
			restaurantRepository.delete(restaurantRepository.findById(restaurantId).get());
			return "Restaurant " + restaurantRepository.findById(restaurantId).get().getRestaurantName() + " is deleted ";
		} else {
			throw new CustomException("Invalid Restaurant ID");
		}
	}



	@Override
	public Restaurant restaurantSignUp(int restaurantId, String restaurantName) throws CustomException{
		if(restaurantRepository.getById(restaurantId) == null) {
			Restaurant restaurant = new Restaurant(restaurantId, restaurantName);
			return restaurantRepository.save(restaurant);
		} else {
			throw new CustomException("Please check your credentials");
		}
		
	}



	@Override
	public List<Dish> addDishes(Dish dish) throws CustomException{
		dishRepository.save(dish);
		if(dishRepository.findAll().size() != 0) {
			return dishRepository.findAll();
		} else {
			throw new CustomException("no dishes avialable");
		}
		
	}

	// Need to complete the code

	@Override
	public Dish UpdateDish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable,
			FoodType vegeterianType, int restaurantId) throws CustomException{
		
		return null;
	}



	@Override
	public Dish createDish(Dish dish) throws CustomException{
		if(dishRepository.findById(dish.getDishId()).isEmpty()) {
			return dishRepository.save(dish);
		} else {
			throw new CustomException("dish with this id "+ dish.getDishId()+ " already exist");
		}
		
	
	}



	@Override
	public String deleteDish(int dishId)throws CustomException {
		if(dishRepository.findById(dishId).isPresent()) {
			dishRepository.delete(dishRepository.getById(dishId));
			return " dishID" + dishId+ "deleted";
		} else {
			throw new CustomException("dish with this id does not exist");
		}
		
	}



	@Override
	public Dish updateDishQuantity(int quantity, int dishId)throws CustomException {
		if(dishRepository.findById(dishId).isPresent()) {
			Dish dish = dishRepository.findById(dishId).get();
			dish.setDishQuantityAvailable(quantity);
			dishRepository.save(dish);
			return dish;
		} else {
			throw new CustomException("Dish with id "+dishId + " not found");
		}
	}


	@Override
	public Dish readDish(int dishId)throws CustomException {
		
		if(dishRepository.findById(dishId).isPresent()) {
			return dishRepository.findById(dishId).get();
		} else {
			throw new CustomException("Dish with id "+dishId + " not found");
		}
		
	}
	
	@Override
	public Set<Dish> getAllDishes(int restaurantId)throws CustomException{
		if(restaurantRepository.findById(restaurantId).isPresent()) {
			Restaurant restaurant =  restaurantRepository.findById(restaurantId).get();
			if(restaurant.getDishes().size() != 0) {
				return restaurant.getDishes();
			} else {
				throw new CustomException("No dishes found");
			}
		} else {
			throw new CustomException("Restaurant with id "+ restaurantId + " not found");
		}
		
		
	}


	@Override
	public Restaurant addAddress(Address address) throws CustomException {
		if(addressRepository.findById(address.getAddressId()).isEmpty()) {
			addressRepository.save(address);
			return address.getRestaurant();
		} else {
			throw new CustomException("Address already exists with the given Id");
		}
		
	}


	@Override
	public Restaurant addRestaurantAddress(String houseNumber, String addressLane1, String addressLane2, String landmark,
			int pincode, String district, String state, int restautantId) throws CustomException {
		if (restaurantRepository.findById(restautantId).isPresent()) {
			Address address = new Address();
			address.setHouseNumber(houseNumber);
			address.setAddressLane1(addressLane1);
			address.setAddressLane2(addressLane2);
			address.setLandmark(landmark);
			address.setPincode(pincode);
			address.setDistrict(district);
			address.setState(state);
			address.setRestaurant(restaurantRepository.getById(restautantId));
			addressRepository.save(address);
			return restaurantRepository.findById(restautantId).get();

		} else {
			throw new CustomException("no Restaurant found");
		}
		
	}
}
