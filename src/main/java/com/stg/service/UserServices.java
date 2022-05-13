package com.stg.service;

import java.util.List;
import java.util.Set;

import com.stg.entity.Address;
import com.stg.entity.User;
import com.stg.exceptions.CustomException;

public interface UserServices {

	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */
	public User userSignUp(User user) throws CustomException;
	public User addAddress(Address address) throws CustomException;
	public User  addUserAddress( String houseNumber, String addressLane1, String addressLane2, String landmark,
			int pincode, String district, String state, long userId) throws CustomException;
	/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */
	public User readUser(long userId, String userPassword) throws CustomException;
	public User readUserByUserNameAndPassword(String userName, String userPassword) throws CustomException;
	public Address getSelectedAddress(int addressId) throws CustomException;
	public List<Address> getAllAddress(long userId) throws CustomException;
	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */

	public User updateUser(User user) throws CustomException; // update
	public User updateUserPassword(long userId, String userPassword, String newUserPassword) throws CustomException;// update
	public User updateUsermobile(String userName, String userPassword, String newUsermobile) throws CustomException;
	public User updateUserEmail(String userName, String userPassword, String newUserEmail) throws CustomException;

	
	public Address updateAddress(Address address) throws CustomException; // update
	public Address updateLandmark(int addressId,String landmark) throws CustomException; // update
	public Address updateHouseNoAndStreet(int addressId,String houseNumber , String addressLane1) throws CustomException; // update

	
	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */
	public String deleteByUserIdAndUserPassword(long userId, String userPassword) throws CustomException;
	public String deleteByUserNameAndUserPassword(String userName, String userPassword) throws CustomException;

	
	public String deleteAddressByUserId(long userId, String userPassword) throws CustomException; // delete
	public String deleteAddressByID(int addressId) throws CustomException; // delete
	
	


}
