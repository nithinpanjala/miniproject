package com.stg.service;

import com.stg.entity.Cart;
import com.stg.entity.Dish;

public interface CartServices {
	
	public Cart createCart(long userId);

	public String addDish(int cartNo, int dishId);

	public String removeDish(int cartNo,  int dishId);


	public String getTotalPrice(int cartNo);

	public String PlaceOrder(int cartNo);
	public Cart getCart(int cartNo);
	
	public String removeCart(int cartNo);

}
