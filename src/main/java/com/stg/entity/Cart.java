package com.stg.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(generator = "cartNo")
	@Column(name = "cartNo", updatable = false, nullable = false)
	private int cartNo;


	@Column(name = "deliveryCharges")
	private float deliveryCharges;

	// public final

	@Column(name = "totalPrice")
	private float totalPrice;

	@OneToOne
	@JoinColumn(name = "user",referencedColumnName = "userId")
	@JsonBackReference(value = "user")
	private User user;
	
	@OneToMany(mappedBy = "cart")
	private Set<CartDishesMapping>  cartDishesMappings;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartNo, float deliveryCharges, float totalPrice, User user,
			Set<CartDishesMapping> cartDishesMappings) {
		super();
		this.cartNo = cartNo;
		this.deliveryCharges = deliveryCharges;
		this.totalPrice = totalPrice;
		this.user = user;
		this.cartDishesMappings = cartDishesMappings;
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

	public Set<CartDishesMapping> getCartDishesMapping() {
		return cartDishesMappings;
	}

	public void setCartDishesMapping(Set<CartDishesMapping> cartDishesMappings) {
		this.cartDishesMappings = cartDishesMappings;
	}

	
}