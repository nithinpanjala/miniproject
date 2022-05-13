package com.stg.repository;


import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	  
	void deleteByUserIdAndUserPassword(long userId,String userPassword);
	 void  deleteByUserNameAndUserPassword(String userName,String userPassword);
	 Optional<User>  findByUserNameAndUserPassword(String userName,String userPassword);
	 Optional<User>  findByUserIdAndUserPassword(long userId,String userPassword);

}
