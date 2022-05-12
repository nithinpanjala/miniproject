package com.stg.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author: Panjala Nithin Kumar
 */

@Entity
@Table(name = "dish")
public class Dish {
	@Id
	@GeneratedValue(generator = "dishId")
	@Column(name = "dishId", updatable = false, nullable = false)
	private int dishId;
	
	@NotEmpty(message = "Please provide a dish name")
	@Column(name = "dishName", nullable = false)
	private String dishName;
	
	@NotEmpty(message = "Please provide cost of the dish")
	@Column(name = "dishPrice", nullable = false)
	private float dishPrice;
	
	@NotEmpty(message = "Please provide the dish quantity available ")
	@Column(name = "dishQuantityAvailable", nullable = false)
	private int dishQuantityAvailable;
	
	@NotEmpty(message = "Please enter the type of the dish (veg/ non-veg) ")
	@Column(name = "isVegeterian", nullable = false)
	private Boolean isVegeterian;
	
	//private enum typeOfFood{ veg, nonVeg }
	
	@ManyToOne
	@JoinColumn(name = "restaurantId", nullable = false)
	@JsonBackReference
	private Restaurant restaurant;

	
	
	 public Boolean getIsVegeterian() {
		return isVegeterian;
	}



	public void setIsVegeterian(Boolean isVegeterian) {
		this.isVegeterian = isVegeterian;
	}



	public Set<DishesInCart> getDishesInCart() {
		return dishesInCart;
	}



	public void setDishesInCart(Set<DishesInCart> dishesInCart) {
		this.dishesInCart = dishesInCart;
	}



	public Dish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable, Boolean isVegeterian,
			Restaurant restaurant, Set<DishesInCart> dishesInCart) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.dishPrice = dishPrice;
		this.dishQuantityAvailable = dishQuantityAvailable;
		this.isVegeterian = isVegeterian;
		this.restaurant = restaurant;
		this.dishesInCart = dishesInCart;
	}



	public Dish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable, Boolean isVegeterian,
			Restaurant restaurant) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.dishPrice = dishPrice;
		this.dishQuantityAvailable = dishQuantityAvailable;
		this.isVegeterian = isVegeterian;
		this.restaurant = restaurant;
	}



	public Dish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable, Boolean isVegeterian) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.dishPrice = dishPrice;
		this.dishQuantityAvailable = dishQuantityAvailable;
		this.isVegeterian = isVegeterian;
	}

	@OneToMany(mappedBy = "dish")
	    Set<DishesInCart> dishesInCart;
	

	public Dish() {
		super();
	}



	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public float getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(float dishPrice) {
		this.dishPrice = dishPrice;
	}

	public int getDishQuantityAvailable() {
		return dishQuantityAvailable;
	}

	public void setDishQuantityAvailable(int dishQuantityAvailable) {
		this.dishQuantityAvailable = dishQuantityAvailable;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
