package com.stg.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.Dish;
import com.stg.entity.Restaurant;
import com.stg.entity.User;
import com.stg.exceptions.CustomException;
import com.stg.repository.DishRepository;

@Service
public class DishesServicesImpl implements DishesServices {

	@Autowired
	DishRepository dishRepository;

	@Override
	public Set<Dish> addDishes(Dish dish) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dish UpdateDish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable,
			Boolean vegeterianType, Restaurant restaurant) throws CustomException {

		if (dishRepository.existsById(dishId)) {
			Dish dish1 = new Dish(dishId, dishName, dishPrice, dishQuantityAvailable, vegeterianType, restaurant);
			return dishRepository.save(dish1);
	
		} else {
			throw new CustomException("no dish found");
		}
	}

	@Override
	public Dish createDish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable,
			Boolean vegeterianType, Restaurant restaurant) {
		if (dishRepository.existsById(dishId)) {
			throw new CustomException("dish already exists ");
	
		} else {
			Dish dish = new Dish(dishId, dishName, dishPrice, dishQuantityAvailable, vegeterianType, restaurant);
			return dishRepository.save(dish);
		}
		

	}

	@Override
	public Dish deleteDish(int dishId) {
		
		if (dishRepository.existsById(dishId)) {
			Dish dish = dishRepository.getById(dishId);
			dishRepository.delete(dish);
			return dish;
	
		} else {
			throw new CustomException("dish does not exists ");
		}
	}

	@Override
	public Dish updateDishQuantity(int quantity, int dishId) {
		
		if (dishRepository.existsById(dishId)) {
			Dish dish = dishRepository.getById(dishId);
			dish.setDishQuantityAvailable(quantity);
			dishRepository.save(dish);
			return dish;
	
		} else {
			throw new CustomException("dish does not exists ");
		}

	}

	@Override
	public Dish readDish(int dishId) {
		
		if (dishRepository.existsById(dishId)) {
			return dishRepository.getById(dishId);
	
		} else {
			throw new CustomException("dish does not exists ");
	}
	}

	@Override
	public List<Dish> readAllDishes() {
		if(dishRepository.findAll() == null) {
			throw new CustomException(" no dishes avaiable ");
		}else {
			return dishRepository.findAll();
		}
	}

}
