package com.stg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Cart;
import com.stg.entity.Dish;
import com.stg.entity.User;
import com.stg.service.CartServices;
import com.stg.service.DishesServices;
import com.stg.service.RestaurantServices;
import com.stg.service.UserServices;

@RestController
@RequestMapping(value = "/cartOperations")
public class CartController {
	@Autowired
	RestaurantServices restaurantServices;
	@Autowired
	UserServices userServices;
	@Autowired
	DishesServices dishesServices;
	
	@Autowired
	CartServices cartServices;

	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */
	@PostMapping(value = "/createCart")
	public ResponseEntity<Cart> createCart(@RequestParam long userId) {
		return new ResponseEntity<Cart>(cartServices.createCart(userId), HttpStatus.ACCEPTED);

	}
	
	@PostMapping(value = "/addDish/{cartNo}/{dishId}")
	public ResponseEntity<Cart> addDish(@RequestParam int cartNo, @RequestParam int dishId) {
		return new ResponseEntity<Cart>(cartServices.addDish(cartNo, dishId), HttpStatus.ACCEPTED);

	}
	
	@DeleteMapping(value = "/removeDish/{cartNo}/{dishId}")
	public ResponseEntity<String> removeDish(@RequestParam int cartNo, @RequestParam int dishId){
		return new ResponseEntity<String>(cartServices.removeDish(cartNo, dishId), HttpStatus.ACCEPTED);
	}


	@GetMapping(value = "/getTotalPrice/{cartNo}")
	public ResponseEntity<String> getTotalPrice(@RequestParam int cartNo) {
		return new ResponseEntity<String>(cartServices.getTotalPrice(cartNo), HttpStatus.ACCEPTED);
 
	}
	@GetMapping(value = "/PlaceOrder/{cartNo}")
	public ResponseEntity<String> PlaceOrder(@RequestParam int cartNo) {
		return new ResponseEntity<String>(cartServices.PlaceOrder(cartNo), HttpStatus.ACCEPTED);
	
	}
	
	@GetMapping(value = "/getCart/{cartNo}")
	public ResponseEntity<Cart> getCart(@RequestParam int cartNo) {
		return new ResponseEntity<Cart>(cartServices.getCart(cartNo), HttpStatus.ACCEPTED);
 
	}

}
