package com.stg.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dishId", updatable = false, nullable = false)
	private int dishId;

	@Column(name = "dishName", nullable = false)
	private String dishName;

	@Column(name = "dishPrice", nullable = false)
	private float dishPrice;

	@Column(name = "dishQuantityAvailable", nullable = false)
	private int dishQuantityAvailable;

	@Column(name = "isVegeterian")
	private FoodType isVegeterian;

	public enum FoodType {
		VEG, NONVEG
	}

	// private enum typeOfFood{ veg, nonVeg }

	@ManyToOne
	@JoinColumn(name = "restaurantId")
	@JsonBackReference(value = "dishes")
	private Restaurant restaurant;

	@ManyToMany(mappedBy = "dishes")
	private List<Cart> carts = new ArrayList<Cart>();

	public Dish(int dishId, String dishName, float dishPrice, int dishQuantityAvailable, FoodType isVegeterian,
			Restaurant restaurant, List<Cart> carts) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.dishPrice = dishPrice;
		this.dishQuantityAvailable = dishQuantityAvailable;
		this.isVegeterian = isVegeterian;
		this.restaurant = restaurant;
		this.carts = carts;
	}

	public Dish() {
		super();

	}

	public Dish(int dishId, @NotEmpty(message = "Please provide a dish name") String dishName,

			@NotEmpty(message = "Please provide cost of the dish") float dishPrice,

			@NotEmpty(message = "Please provide the dish quantity available ") int dishQuantityAvailable,

			@NotEmpty(message = "Please enter the type of the dish (veg/ non-veg) ") FoodType isVegeterian,
			Restaurant restaurant) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.dishPrice = dishPrice;
		this.dishQuantityAvailable = dishQuantityAvailable;
		this.isVegeterian = isVegeterian;
		this.restaurant = restaurant;
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

	public FoodType getIsVegeterian() {
		return isVegeterian;
	}

	public void setIsVegeterian(FoodType isVegeterian) {
		this.isVegeterian = isVegeterian;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

}
