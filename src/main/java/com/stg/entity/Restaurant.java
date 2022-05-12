
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
	

	@NotEmpty(message = "Please set a restaurant password")
	@Column(name = "restaurantPassword", nullable = false)
	private String restaurantPassword;
	
	@NotEmpty(message = "Please enter the amount you want to give as discount")
	@Column(name = "discount", nullable = false)
	private float discount;
	
	
	
	@OneToOne(mappedBy = "restaurant")
	@JsonManagedReference
	private Address restaurantAddress;
	
	
	@OneToMany(mappedBy = "restaurant")
	@JsonManagedReference
	private Set<Dish> dishes;


	
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(int restaurantId, String restaurantName, String restaurantPassword, Address restaurantAddress,
			Set<Dish> dishes) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantPassword = restaurantPassword;
		this.restaurantAddress = restaurantAddress;
		this.dishes = dishes;
	}

	public Restaurant(int restaurantId, String restaurantName, String restaurantPassword, Address restaurantAddress) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantPassword = restaurantPassword;
		this.restaurantAddress = restaurantAddress;
	}
	
	public Restaurant(int restaurantId, String restaurantName, String restaurantPassword) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantPassword = restaurantPassword;
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

	public String getRestaurantPassword() {
		return restaurantPassword;
	}

	public void setRestaurantPassword(String restaurantPassword) {
		this.restaurantPassword = restaurantPassword;
	}

	public Address getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(Address restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

	public Set<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(Set<Dish> dishes) {
		this.dishes = dishes;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	

}
