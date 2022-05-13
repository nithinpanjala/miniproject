package com.stg.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.Cart;
import com.stg.entity.CartDishesMapping;
import com.stg.entity.Dish;
import com.stg.repository.CartDishesMappingRepository;
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
	
	@Autowired
	CartDishesMappingRepository cartDishesMappingRepository;

	@Override
	public Cart createCart(long userId) {
		Cart cart = new Cart(userRepository.findById(userId).get());
		return cartRepository.save(cart);
	}

	@Override
	public Cart addDish(int cartNo, int dishId, int quantity) {
		Cart cart = cartRepository.findById(cartNo).get();
		CartDishesMapping cartDishesMapping = new CartDishesMapping();
		cartDishesMapping.setDish(dishRepository.findById(dishId).get());
		cartDishesMapping.setCart(cartRepository.findById(cartNo).get());
		cartDishesMapping.setQuantity(quantity);
		cartDishesMappingRepository.save(cartDishesMapping);
		cart.getCartDishesMapping().add(cartDishesMapping);
		cartRepository.save(cart);		
		return cart;
	}

	@Override
	public String removeDish(int cartNo, int dishId) {
		cartRepository.findById(cartNo).get().getCartDishesMapping().remove(cartDishesMappingRepository.findByCartNoAndDishId(cartNo, dishId));
		return "Selected Dish Removed";
	}

	@Override
	public Cart updateDishQuantity(int cartNo, int dishId, int quantity) {
		Cart cart = cartRepository.findById(cartNo).get();
		
		CartDishesMapping cartDishesMapping =  cartDishesMappingRepository.findByCartNoAndDishId(cartNo, dishId).get();
		cartDishesMapping.setQuantity(quantity);
		cartDishesMappingRepository.save(cartDishesMapping);
		return cart;
	}

	@Override
	public String getTotalPrice(int cartNo) {
		float totalPrice = 0;

		Cart cart1 = cartRepository.getById(cartNo);
		//code comes in
		return "The total price of the cart is : " + totalPrice;
	}

	@Override
	public String PlaceOrder(int cartNo) {
		Cart cart = cartRepository.findById(cartNo).get();
		//code comes in
		return "Order placed";

	}

	public Cart getCart(int cartNo) {
		return cartRepository.findById(cartNo).get();
	}

}
