package com.stg.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.Address;
import com.stg.entity.User;
import com.stg.exceptions.CustomException;
import com.stg.exceptions.GlobalExceptions;
import com.stg.repository.AddressRepository;
import com.stg.repository.UserRepository;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;


	@Override
	public User userSignUp(User user) {
		return userRepository.save(user);
	}

	
	@Override
	public User updateUser(User user) {
	return userRepository.save(user);
	}

	@Override
	public User updateUserPassword(long userId, String userPassword, String newUserPassword) throws CustomException {

		User user = userRepository.findById(userId).get();
		if (user == null) {
			throw new CustomException("no user found");
		} else {
			user.setUserPassword(newUserPassword);
			System.out.println("***************");
			System.out.println(user.getUserPassword());
			System.out.println("***************");
			return userRepository.save(user);
		}

	}
	
	@Override
	public User updateUsermobile(String userName, String userPassword, String newUsermobile) throws CustomException {
		
		if (userRepository.findByUserNameAndUserPassword(userName , userPassword).isPresent()) {
			User user = userRepository.findByUserNameAndUserPassword(userName , userPassword).get();
			user.setUsermobile(newUsermobile);
			return userRepository.save(user);
		} else {
			throw new CustomException("no user found");
		}
	}
	
	
	@Override
	public User updateUserEmail(String userName, String userPassword, String newUserEmail) throws CustomException {
		
		if (userRepository.findByUserNameAndUserPassword(userName , userPassword).isPresent()) {
			User user = userRepository.findByUserNameAndUserPassword(userName , userPassword).get();
			user.setUserEmail(newUserEmail);
			return userRepository.save(user);
		} else {
			throw new CustomException("no user found");
		}
	}
	

	@Override
	public User readUser(long userId, String userPassword) throws CustomException {

		if (userRepository.findById(userId).isPresent()) {

			return userRepository.findById(userId).get();

		} else {
			throw new CustomException("no user found");
		}
	}
	@Override
	public User readUserByUserNameAndPassword(String userName, String userPassword) throws CustomException{
		if (userRepository.findByUserNameAndUserPassword(userName , userPassword).isPresent()) {

			return userRepository.findByUserNameAndUserPassword(userName , userPassword).get();

		} else {
			throw new CustomException("no user found");
		}
	}

	@Override
	public User addAddress(Address address)  throws CustomException {
		addressRepository.save(address);
		return address.getUser();
	}
	@Override
	public Address updateAddress(Address address) throws CustomException
	{
		return	addressRepository.save(address);
	}
	@Override
	public Address updateLandmark(int addressId,String landmark) throws CustomException{ // update
		if(addressRepository.existsById(addressId)) {
			Address address= addressRepository.getById(addressId);
			address.setLandmark(landmark);
			return addressRepository.save(address);
		}else {
			throw new CustomException("no address with that Id found");
		}
	}
	@Override
	public Address updateHouseNoAndStreet(int addressId,String houseNumber , String addressLane1) throws CustomException{
		
		if(addressRepository.existsById(addressId)) {
			Address address= addressRepository.getById(addressId);
			address.setHouseNumber(houseNumber);
			address.setAddressLane1(addressLane1);
			return addressRepository.save(address);
		}else {
			throw new CustomException("no address with that Id found");
		}
	}



	@Override
	public String deleteByUserIdAndUserPassword(long userId, String userPassword) throws CustomException  {
		if(userRepository.findByUserIdAndUserPassword(userId,userPassword).isEmpty()) {
			throw new CustomException("no User Found with the Id :"+ userId);
			
		}else {
			List<Address> addresses = getAllAddress(userId);
			for (Address address : addresses) {
				addressRepository.deleteById(address.getAddressId());
			}
			userRepository.deleteById(userId);
			return "User "+ userId + " deleted";
		}
		
		
		
	}

	@Override
	public String deleteByUserNameAndUserPassword(String userName, String userPassword) throws CustomException  {
		if(userRepository.findByUserNameAndUserPassword(userName, userPassword).isEmpty()) {
			throw new CustomException("no address with that Id found");
			
		}else {
			
			List<Address> addresses = getAllAddress(userRepository.findByUserNameAndUserPassword(userName, userPassword).get().getUserId());
			for (Address address : addresses) {
				addressRepository.deleteById(address.getAddressId());
			}
			userRepository.deleteById(userRepository.findByUserNameAndUserPassword(userName, userPassword).get().getUserId());
			return "User "+ userName + " deleted";

		}
	}

	@Override
	public List<Address> getAllAddress(long userId)  throws CustomException {
		User user = userRepository.findById(userId).get();
		if(user== null) {
			throw new CustomException("Invalid User ID and password");
		}else {
		return addressRepository.findAllByUser(user);
		}

	}
	
	@Override
	public Address getSelectedAddress(int addressId)  throws CustomException {
		if(addressRepository.existsById(addressId)) {
			return addressRepository.findById(addressId).get();
	
		}else {
			throw new CustomException("Invalid User address Id");
		}

	}
	
	@Override
	public String deleteAddressByUserId(long userId , String userPassword) throws CustomException{
		// delete
		if(userRepository.findByUserIdAndUserPassword(userId,userPassword).isEmpty()) {
			throw new CustomException("no User Found with the Id :"+ userId);
			
		}else {
			List<Address> addresses = getAllAddress(userId);
			for (Address address : addresses) {
				addressRepository.deleteById(address.getAddressId());
			}
			return "All the addresses of the User "+ userId + " are deleted";
		}
	}
	
	@Override
	public String deleteAddressByID(int addressId) throws CustomException{
		if(addressRepository.existsById(addressId)) {
			 addressRepository.deleteById(addressId);
			 return "The selected address is deleted";
		}else {
			throw new CustomException("no address with that Id found");
		}
	}
	
	@Override
	public User  addUserAddress( String houseNumber, String addressLane1, String addressLane2, String landmark,
			int pincode, String district, String state, long userId) throws CustomException{

		if (userRepository.findById(userId).isPresent()) {
			Address address = new Address();
			address.setHouseNumber(houseNumber);
			address.setAddressLane1(addressLane1);
			address.setAddressLane2(addressLane2);
			address.setLandmark(landmark);
			address.setPincode(pincode);
			address.setDistrict(district);
			address.setState(state);
			address.setUser(userRepository.getById(userId));
			addressRepository.save(address);
			return userRepository.findById(userId).get();

		} else {
			throw new CustomException("no user found");
		}
		
		
	}


}
