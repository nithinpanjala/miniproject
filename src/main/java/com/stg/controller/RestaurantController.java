package com.stg.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

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

import com.stg.entity.Address;
import com.stg.entity.Dish;
import com.stg.entity.Restaurant;
import com.stg.entity.User;
import com.stg.service.RestaurantServices;

@RestController
@RequestMapping(value = "/RestaurantOperations")
public class RestaurantController {

	@Autowired
	RestaurantServices restaurantServices;

	/*
	 *  Restaurant create operations
	 */
	
	@PostMapping(value = "/createRestaurant/{restaurantId}/{restaurantName}/")
	public  ResponseEntity<Restaurant > createRestaurant(@PathVariable("restaurantId") int restaurantId,@Valid @PathVariable("restaurantName") String restaurantName
			  ) {
		Restaurant restaurant= restaurantServices.restaurantSignUp(restaurantId, restaurantName);
		return new ResponseEntity<Restaurant >(restaurant, HttpStatus.CREATED);

	}
	
	
	@PostMapping(value = "/addAddress/{address}")
	public ResponseEntity<Restaurant> addAddress(@Valid @RequestBody Address address) {

		return new ResponseEntity<Restaurant>(restaurantServices.addAddress(address), HttpStatus.ACCEPTED);

	}
	@PostMapping(value = "/addUserAddress")
	public ResponseEntity<Restaurant> addUserAddress( @RequestParam String houseNumber, @RequestParam String addressLane1,@RequestParam String addressLane2, @RequestParam String landmark,
			 @RequestParam int pincode, @RequestParam String district, @RequestParam String state, @RequestParam int restaurantId) {

		return new ResponseEntity<Restaurant>(restaurantServices.addRestaurantAddress(   houseNumber,  addressLane1,  addressLane2,  landmark,
				 pincode,  district,  state,  restaurantId), HttpStatus.ACCEPTED);

	}

	

	/*
	 *  Restaurant read operations
	 */

	@GetMapping(value = "/getRestaurant/{restaurantId}")
	public ResponseEntity<Restaurant > readRestaurant(@PathVariable("restaurantId") int restaurantId) {
		return new ResponseEntity<Restaurant >(restaurantServices.readRestaurant(restaurantId), HttpStatus.FOUND);

	}
	


	@PutMapping(value = "/updateRestaurant/{restaurant}")
	public ResponseEntity<Restaurant > updateRestaurant(@Valid @RequestBody Restaurant restaurant) {
		return new ResponseEntity<Restaurant >( restaurantServices.updateRestaurant(restaurant), HttpStatus.OK);

	}

	@DeleteMapping(value = "/deleteRestaurant/{restaurantId}")
	public ResponseEntity<String>  deleteRestaurant(@PathVariable("restaurantId") int restaurantId) {

		return new ResponseEntity<String >(restaurantServices.deleteRestaurant(restaurantId), HttpStatus.OK);

	
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
	public ResponseEntity<String> deleteDish(@PathVariable int dishId) {
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
