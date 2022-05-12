package com.stg.repository;


import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	  
	 Optional<User> deleteByUserIdAndUserPassword(long userId,String userPassword);
	 Optional<User>  deleteByUserNameAndUserPassword(String userName,String userPassword);
	 Optional<User>  findByUserNameAndUserPassword(String userName,String userPassword);
	 Optional<User>  findByUserIdAndUserPassword(long userId,String userPassword);

}
