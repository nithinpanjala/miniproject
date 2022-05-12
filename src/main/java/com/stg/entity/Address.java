package com.stg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author: Panjala Nithin Kumar
 */

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(generator = "addressId")
	@Column(name = "addressId", updatable = false, nullable = false)
	private int addressId;
	
	@NotEmpty(message = "Please provide a house number")
	@Column(name = "houseNumber", nullable = false)
	private String houseNumber;
	
	@NotEmpty(message = "Please provide an address lane 1")
	@Column(name = "addressLane1", nullable = false)
	private String addressLane1;
	
	
	@Column(name = "addressLane2" ,nullable = false)
	private String addressLane2;
	
	@NotEmpty(message = "Please provide a landmark")
	@Column(name = "landmark", nullable = false)
	private String landmark;
	
	@NotEmpty(message = "Please provide a pincode")
	@Column(name = "pincode", nullable = false)
	private int pincode;
	
	@NotEmpty(message = "Please provide the district name")
	@Column(name = "district", nullable = false)
	private String district;
	
	@NotEmpty(message = "Please provide the name of the state")
	@Column(name = "state", nullable = false)
	private String state;
	
	
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	@JsonBackReference
	private User user;
	
	@OneToOne
	@JoinColumn(name = "restaurantAddress", nullable = false)
	@JsonBackReference
	private Restaurant restaurant;

	public Address() {
		super();
	}

	public Address(int addressId, String houseNumber, String addressLane1, String addressLane2, String landmark,
			int pincode, String district, String state, User user) {
		super();
		this.addressId = addressId;
		this.houseNumber = houseNumber;
		this.addressLane1 = addressLane1;
		this.addressLane2 = addressLane2;
		this.landmark = landmark;
		this.pincode = pincode;
		this.district = district;
		this.state = state;
		this.user = user;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getAddressLane1() {
		return addressLane1;
	}

	public void setAddressLane1(String addressLane1) {
		this.addressLane1 = addressLane1;
	}

	public String getAddressLane2() {
		return addressLane2;
	}

	public void setAddressLane2(String addressLane2) {
		this.addressLane2 = addressLane2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
