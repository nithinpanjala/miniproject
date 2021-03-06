package com.stg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.Cart;

import com.stg.entity.Dish;

import com.stg.repository.CartRepository;
import com.stg.repository.DishRepository;
import com.stg.repository.UserRepository;

@Service
public class CartServicesImpl implements CartServices {

	@Autowired
	CartRepository cartRepository;

	@Autowired
	DishRepository dishRepository;

	@Autowired
	UserRepository userRepository;


	@Override
	public Cart createCart(long userId) {
		Cart cart = new Cart(userRepository.findById(userId).get());
		return cartRepository.save(cart);
	}

	@Override
	public String addDish(int cartNo, int dishId) {
		Cart cart = cartRepository.findById(cartNo).get();
		Dish dish = dishRepository.findById(dishId).get();
		dish.getCarts().add(cart);
		cart.getDishes().add(dish);
		//dishRepository.save(dish);
		//return cartRepository.save(cart);
		//return cart;
		return dishId + "added to "+ cartNo;

	}

	@Override
	public String removeDish(int cartNo, int dishId) {
		Cart cart = cartRepository.findById(cartNo).get();
		/*
		 * Dish dish = dishRepository.findById(dishId).get();
		 * dish.getCart().setCartNo(cartNo);
		 */
		  List<Dish> list = cart.getDishes();
		  list.remove(dishRepository.findById(dishId).get()); 
		  cart.setDishes(list);
	    cartRepository.save(cart);	
		return "Selected Dish Removed";
	}

	

	@Override
	public String getTotalPrice(int cartNo) {
		float totalPrice = 0;
Cart cart = cartRepository.findById(cartNo).get();
		
		cart.getDishes();
		for (Dish dish : cart.getDishes()) {
			totalPrice = totalPrice + dishRepository.getById(dish.getDishId()).getDishPrice();

		}
		cart.setTotalPrice(totalPrice);
		cartRepository.save(cart);
		return "The total price of the cart is : " + totalPrice;
	}

	@Override
	public String PlaceOrder(int cartNo) {
		Cart cart = cartRepository.findById(cartNo).get();
		
		cart.getDishes();
		for (Dish dish : cart.getDishes()) {
			int n = dishRepository.getById(dish.getDishId()).getDishQuantityAvailable();
			dishRepository.getById(dish.getDishId()).setDishQuantityAvailable(n-1);
			dishRepository.save(dish);
		}
		return "Order placed";

	}

	public Cart getCart(int cartNo) {
		return cartRepository.findById(cartNo).get();
	}

	@Override
	public String removeCart(int cartNo) {
		cartRepository.deleteById(cartNo);
		return "cart "+cartNo +" deleted";
	}

}
