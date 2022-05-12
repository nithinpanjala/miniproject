package com.stg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DishesInCart {
	   @Id
	   private Long id;

	    @ManyToOne
	    @JoinColumn(name = "cartNo")
	    private  Cart cart;

	    @ManyToOne
	    @JoinColumn(name = "dishId")
	    private   Dish dish;

	    private int quantity;

		public DishesInCart() {
			super();
			// TODO Auto-generated constructor stub
		}

		public DishesInCart(Long id, Cart cart, Dish dish, int quantity) {
			super();
			this.id = id;
			this.cart = cart;
			this.dish = dish;
			this.quantity = quantity;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Cart getCart() {
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}

		public Dish getDish() {
			return dish;
		}

		public void setDish(Dish dish) {
			this.dish = dish;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	    
	    // additional properties
	    // standard constructors, getters, and setters
	}