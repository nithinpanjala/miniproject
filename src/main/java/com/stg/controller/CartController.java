package com.stg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	
}
