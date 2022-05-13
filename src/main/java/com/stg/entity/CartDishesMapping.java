package com.stg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cartDishesMapping")
public class CartDishesMapping {

    @Id
    @GeneratedValue(generator = "cartDishesMappingId")
    int cartDishesMappingId;

    @ManyToOne
    @JoinColumn(name = "cartNo",referencedColumnName = "cartNo")
    Cart cart;

    @ManyToOne
    @JoinColumn(name = "dishId",referencedColumnName = "dishId")
    Dish dish;

	@Column(name = "quantity")
    int quantity;

	public CartDishesMapping(int cartDishesMappingId, Cart cart, Dish dish, int quantity) {
		super();
		this.cartDishesMappingId = cartDishesMappingId;
		this.cart = cart;
		this.dish = dish;
		this.quantity = quantity;
	}

	public CartDishesMapping() {
		super();

	}

	public int getCartDishesMappingId() {
		return cartDishesMappingId;
	}

	public void setCartDishesMappingId(int cartDishesMappingId) {
		this.cartDishesMappingId = cartDishesMappingId;
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

}
