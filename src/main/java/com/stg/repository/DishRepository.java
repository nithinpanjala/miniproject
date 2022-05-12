package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer> {

}
