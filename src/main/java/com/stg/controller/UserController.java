package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Address;
import com.stg.entity.User;
import com.stg.exceptions.CustomException;
import com.stg.exceptions.GlobalExceptions;
import com.stg.service.UserServices;

@RestController
@RequestMapping(value = "/foodOperations")
public class UserController {

	@Autowired
	private UserServices userServices;

	
	/*
	 * *************************************************************************
	 *  create operations
	 * ***********************************************************************
	 */
	
	@PostMapping(value = "/createUser/{user}")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		return new ResponseEntity<User>(userServices.userSignUp(user), HttpStatus.ACCEPTED);

	}

	@PostMapping(value = "/addAddress/{address}")
	public ResponseEntity<User> addAddress(@RequestBody Address address) {

		return new ResponseEntity<User>(userServices.addAddress(address), HttpStatus.ACCEPTED);

	}

	/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */

	@GetMapping(value = "/getUser/{userId}/{userPassword}")
	public ResponseEntity<User> readUser(@PathVariable("userId") long userId,
			@PathVariable("userPassword") String userPassword) {
		return new ResponseEntity<User>(userServices.readUser(userId, userPassword), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getUser/{userName}/{userPassword}")
	public ResponseEntity<User> readUserByUserNameAndPassword(@PathVariable("userName") String userName,
			@PathVariable("userPassword") String userPassword) {
		return new ResponseEntity<User>(userServices.readUserByUserNameAndPassword(userName, userPassword), HttpStatus.OK);

	}
	@GetMapping(value = "/getSelectedAddress/{addressId}")
	public ResponseEntity<Address> getSelectedAddress(@PathVariable("addressId") int addressId) {

		return new ResponseEntity<Address>(userServices.getSelectedAddress(addressId), HttpStatus.ACCEPTED);

	}
	@GetMapping(value = "/getAllAddress/{userId}")
	public ResponseEntity<List<Address>> getAllAddress(@PathVariable("userId") long userId) {

		return new ResponseEntity<List<Address>>(userServices.getAllAddress(userId), HttpStatus.ACCEPTED);

	}

	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */

	

	@DeleteMapping(value = "/deleteUser/{userId}/{userPassword}")
	public ResponseEntity<String> deleteByUserIdAndUserPassword(@PathVariable("userId") long userId, @PathVariable("userPassword") String userPassword) {
		return new ResponseEntity<String>(userServices.deleteByUserIdAndUserPassword(userId, userPassword), HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteByUserNameAndUserPassword/{userName}/{userPassword}")
	public ResponseEntity<String> deleteByUserName(@PathVariable("userName") String userName,
			@PathVariable("userPassword") String userPassword) {
		return new ResponseEntity<String> ( userServices.deleteByUserNameAndUserPassword(userName, userPassword), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteAddress/{address}")
	public ResponseEntity<String> deleteAddress(@PathVariable("address") Address address) {
		return new ResponseEntity<String> ( userServices.deleteAddress(address), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteAddressByID/{addressId}")
	public ResponseEntity<String> deleteAddressByID(@PathVariable("addressId") int addressId) {
		return new ResponseEntity<String> ( userServices.deleteAddressByID(addressId), HttpStatus.OK);
	}
	


	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */


	@PutMapping(value = "/updateUser/{user}")
	public  ResponseEntity<User> updateUser(@RequestBody User user) {
		return new ResponseEntity<User>(userServices.updateUser(user), HttpStatus.ACCEPTED);

	}
	
	@PutMapping(value = "/updateUserPassword")
	public ResponseEntity<User> updateUserPassword(@RequestParam long userId, @RequestParam String userPassword,
			@RequestParam String newUserPassword) {
		return new ResponseEntity<User>(userServices.updateUserPassword(userId, userPassword, newUserPassword), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/updateUsermobile")
	public ResponseEntity<User> updateUsermobile(@RequestParam String userName, @RequestParam String userPassword,
			@RequestParam String newUsermobile) {
		return new ResponseEntity<User>(userServices.updateUsermobile(userName, userPassword, newUsermobile), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/updateUserEmail")
	public ResponseEntity<User> updateUserEmail(@RequestParam String userName, @RequestParam String userPassword,
			@RequestParam String newUserEmail) {
		return new ResponseEntity<User>(userServices.updateUserEmail(userName, userPassword, newUserEmail), HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping(value = "/updateAddress/{address}")
	public  ResponseEntity<Address> updateUser(@RequestBody Address address) {
		return new ResponseEntity<Address>(userServices.updateAddress(address), HttpStatus.ACCEPTED);

	}
	
	
	@PutMapping(value = "/updateLandmark")
	public ResponseEntity<Address> updateUserEmail(@RequestParam int addressId, @RequestParam String landmark) {
		return new ResponseEntity<Address>(userServices.updateLandmark(addressId, landmark), HttpStatus.ACCEPTED);
	}
	


	@PutMapping(value = "/updateHouseNoAndStreet")
	public ResponseEntity<Address> updateHouseNoAndStreet(@RequestParam int addressId, @RequestParam String houseNumber, @RequestParam String addressLane1) {
		return new ResponseEntity<Address>(userServices.updateHouseNoAndStreet(addressId, houseNumber,addressLane1), HttpStatus.ACCEPTED);
	}
	





}
