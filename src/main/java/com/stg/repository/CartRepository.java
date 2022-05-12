package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
