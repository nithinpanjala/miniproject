package com.stg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.CartDishesMapping;
import com.stg.entity.User;

public interface CartDishesMappingRepository extends JpaRepository<CartDishesMapping, Integer> {
	 Optional<CartDishesMapping>  findByCartNoAndDishId(int cartNo, int dishId);

}
