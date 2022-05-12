package com.stg.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Dish;
import com.stg.entity.Restaurant;
import com.stg.service.RestaurantServices;

@RestController
@RequestMapping(value = "/RestaurantOperations")
public class RestaurantController {

	@Autowired
	RestaurantServices restaurantServices;

	/*
	 *  Restaurant create operations
	 */
	
	@PostMapping(value = "/createRestaurant/{restaurantId}/{restaurantName}/{restaurantPassword}")
	public  ResponseEntity<Restaurant > createRestaurant(@PathVariable("restaurantId") int restaurantId, @PathVariable("restaurantName") String restaurantName,
			@PathVariable("restaurantPassword") String restaurantPassword) {
		Restaurant restaurant= restaurantServices.restaurantSignUp(restaurantId, restaurantName, restaurantPassword);
		return new ResponseEntity<Restaurant >(restaurant, HttpStatus.CREATED);

	}

	

	/*
	 *  Restaurant read operations
	 */

	@GetMapping(value = "/getRestaurant/{restaurantId}/{restaurantPassword}")
	public ResponseEntity<Restaurant > readRestaurant(@PathVariable("restaurantId") int restaurantId,
			@PathVariable("restaurantPassword") String restaurantPassword) {
		return new ResponseEntity<Restaurant >(restaurantServices.readRestaurant(restaurantId, restaurantPassword), HttpStatus.FOUND);

	}
	


	@PutMapping(value = "/updateRestaurant/{restaurant}")
	public ResponseEntity<Restaurant > updateRestaurant(@RequestBody Restaurant restaurant) {
		return new ResponseEntity<Restaurant >( restaurantServices.updateRestaurant(restaurant), HttpStatus.OK);

	}

	@DeleteMapping(value = "/deleteRestaurant/{restaurantId}/{restaurantPassword}")
	public ResponseEntity<String>  deleteRestaurant(@PathVariable("restaurantId") int restaurantId,
			@PathVariable("restaurantPassword") String restaurantPassword) {

		return new ResponseEntity<String >(restaurantServices.deleteRestaurant(restaurantId, restaurantPassword), HttpStatus.OK);

	
	}
	
	/* *************************************************************************
	 *  						Dish operations
	 *	***********************************************************************
	 */
	
	
	@PostMapping(value = "/addDishes/{dish}")
	public ResponseEntity<List<Dish> > addDishes(@RequestBody Dish dish ) {

		return new ResponseEntity<List<Dish> >(restaurantServices.addDishes(dish), HttpStatus.OK);

	}

	@DeleteMapping(value = "/deleteDish/{dishId}")
	public ResponseEntity<String> deleteDish(@RequestBody int dishId) {
		return new ResponseEntity<String>(restaurantServices.deleteDish(dishId), HttpStatus.FOUND);
	}

	@PutMapping(value = "/updateDishQuantity/{quantity}/{dishId}")
	public ResponseEntity<Dish> updateDishQuantity(@RequestParam  int quantity,@RequestParam int dishId) {
		return new ResponseEntity<Dish>(restaurantServices.updateDishQuantity(quantity, dishId), HttpStatus.ACCEPTED);

	}
	

	@GetMapping(value = "/readDish/{Dishid}")
	public ResponseEntity<Dish> readDish(@RequestParam int Dishid) {
		return new ResponseEntity<Dish>(restaurantServices.readDish(Dishid), HttpStatus.FOUND);
	}
	
	@GetMapping(value = "/getAllDishes/{restaurantId}")
	public ResponseEntity<Set<Dish>> getAllDishes(@RequestParam int restaurantId) {
		return new ResponseEntity<Set<Dish>>(restaurantServices.getAllDishes(restaurantId), HttpStatus.FOUND);
	}


	
}
