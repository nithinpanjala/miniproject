
package com.stg.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author: Panjala Nithin Kumar
 */

@Entity
@Table(name = "restaurant")
public class Restaurant {

	@Id
	@GeneratedValue(generator = "restaurantId")
	@Column(name = "restaurantId", updatable = false, nullable = false)
	private int restaurantId;
	
	@NotEmpty(message = "Please provide a restaurant Name")
	@Column(name = "restaurantName",unique = true, nullable = false)
	private String restaurantName;

	@OneToOne(mappedBy = "restaurant")
	private Address address;
	
	
	@OneToMany(mappedBy = "restaurant")
	@JsonManagedReference(value = "dishes")
	private Set<Dish> dishes;


	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public String getRestaurantName() {
		return restaurantName;
	}


	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	

	public Set<Dish> getDishes() {
		return dishes;
	}


	public void setDishes(Set<Dish> dishes) {
		this.dishes = dishes;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Restaurant(int restaurantId, @NotEmpty(message = "Please provide a restaurant Name") String restaurantName,
			Address address, Set<Dish> dishes) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		this.dishes = dishes;
	}


	public Restaurant(int restaurantId, @NotEmpty(message = "Please provide a restaurant Name") String restaurantName) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
	}


	
}
