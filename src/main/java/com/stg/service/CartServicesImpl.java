package com.stg.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.Cart;
import com.stg.entity.Dish;
import com.stg.repository.CartRepository;
import com.stg.repository.DishRepository;

@Service
public class CartServicesImpl implements CartServices {

	/*
	 * @Autowired CartRepository cartRepository;
	 * 
	 * @Autowired DishRepository dishRepository;
	 * 
	 * @Override public Cart addDish(int cartNo ,Dish dish ,int quantity) { Cart
	 * cart = cartRepository.getById(cartNo); cart.getDishes().put(dish.getDishId(),
	 * quantity); cartRepository.save(cart); return cart; }
	 * 
	 * @Override public Cart removeDish(int cartNo ,Dish dish) { Cart cart =
	 * cartRepository.getById(cartNo); cart.getDishes().remove(cart);
	 * cartRepository.save(cart); return cart; }
	 * 
	 * @Override public Cart updateDishQuantity(int cartNo ,Dish dish, int quantity)
	 * { Cart cart = cartRepository.getById(cartNo);
	 * cart.getDishes().replace(dish.getDishId(), quantity); return cart; }
	 * 
	 * @Override public Float getTotalPrice(int cartNo ,Cart cart) { float
	 * totalPrice = 0;
	 * 
	 * Cart cart1 = cartRepository.getById(cartNo); for (Map.Entry<Integer, Integer>
	 * iterator : cart1.getDishes().entrySet()) { Dish dish =
	 * dishRepository.getById(iterator.getKey()); totalPrice += dish.getDishPrice()
	 * * iterator.getValue(); } return totalPrice; }
	 * 
	 * @Override public Float getTotalPriceAfterDiscount(int cartNo ,Float discount)
	 * { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public Cart PlaceOrder(int cartNo ,Cart cart) { // TODO
	 * Auto-generated method stub return null; }
	 */
}
