package com.stg.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartNo", updatable = false, nullable = false)
	private int cartNo;

	@Column(name = "deliveryCharges")
	private float deliveryCharges;

	// public final

	@Column(name = "totalPrice")
	private float totalPrice;

	@OneToOne
	@JoinColumn(name = "user", referencedColumnName = "userId")
	/* @JsonBackReference(value = "user") */
	private User user;

	@JsonSerialize(contentUsing = com.stg.exceptions.MySerializer.class)
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "cartdish", joinColumns = {
			@JoinColumn(name = "cartNo", referencedColumnName = "cartNo", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "dishId", referencedColumnName = "dishId", nullable = false, updatable = false), })
	private List<Dish> dishes = new ArrayList<Dish>();

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Cart(int cartNo, float deliveryCharges, float totalPrice, User user, List<Dish> dishes) {
		super();
		this.cartNo = cartNo;
		this.deliveryCharges = deliveryCharges;
		this.totalPrice = totalPrice;
		this.user = user;
		this.dishes = dishes;
	}


	public Cart(int cartNo) {
		super();
		this.cartNo = cartNo;
	}

	public Cart(int cartNo, User user) {
		super();
		this.cartNo = cartNo;
		this.user = user;
	}

	public Cart(User user) {
		super();
		this.user = user;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public float getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(float deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public List<Dish> getDishes() {
		return dishes;
	}


	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

	

}