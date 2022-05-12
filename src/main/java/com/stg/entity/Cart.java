package com.stg.entity;

import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(generator = "cartNo")
	@Column(name = "cartNo", updatable = false, nullable = false)
	private int cartNo;

	@NotEmpty
	@Column(name = "deliveryCharges", nullable = false)
	private float deliveryCharges;

	// public final

	@NotEmpty
	@Column(name = "totalPrice", nullable = false)
	private float totalPrice;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	@OneToMany(mappedBy = "cart")
	Set<DishesInCart> dishesInCart;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartNo, @NotEmpty float deliveryCharges, @NotEmpty float totalPrice, User user,
			Set<DishesInCart> dishesInCart) {
		super();
		this.cartNo = cartNo;
		this.deliveryCharges = deliveryCharges;
		this.totalPrice = totalPrice;
		this.user = user;
		this.dishesInCart = dishesInCart;
	}

	public Cart(int cartNo, @NotEmpty float deliveryCharges, @NotEmpty float totalPrice, User user) {
		super();
		this.cartNo = cartNo;
		this.deliveryCharges = deliveryCharges;
		this.totalPrice = totalPrice;
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

	public Set<DishesInCart> getDishesInCart() {
		return dishesInCart;
	}

	public void setDishesInCart(Set<DishesInCart> dishesInCart) {
		this.dishesInCart = dishesInCart;
	}

}