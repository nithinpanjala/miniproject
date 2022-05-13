package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.Address;
import com.stg.entity.User;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	List<Address> findAllByUser(User user);
	void deleteByUser(User user);
	
}
