package com.stg.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author: Panjala Nithin Kumar
 */

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", updatable = false, nullable = false)
	private long userId;

	@NotEmpty(message = "Please provide a userName")
	@Column(name = "userName",unique = true, updatable = false, nullable = false)
	private String userName;

	@NotEmpty(message = "Please provide a userPassword")
	@Column(name = "userPassword", nullable = false)
	private String userPassword;

	@NotEmpty(message = "Please provide a userfirstName")
	@Column(name = "userfirstName", nullable = false)
	@Size(min = 3, max = 15, message = "User First Name must be in the range of 3 and 15")
	private String userfirstName;

	@NotEmpty(message = "Please provide a userlastName")
	@Column(name = "userlastName", nullable = false)
	@Size(min = 3, max = 15, message = "User First Name must be in the range of 3 and 15")
	private String userlastName;

	@NotEmpty(message = "Please provide a usermobile")
	@Column(name = "usermobile", nullable = false)
	@Size(min = 10, max = 10, message = "usermobile must be 10 digits")
	private String usermobile;

	@NotEmpty(message = "Please provide a userEmail")
	@Email(message = "Enter a valid User Email ID")
	@Column(name = "userEmail", nullable = false)
	private String userEmail;

	@JsonManagedReference(value = "user")
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Address> addresses;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Cart cart;

	public User() {
		super();
	}

	public User(long userId, String userName, String userPassword, String userfirstName, String userlastName,
			String usermobile, String userEmail, Set<Address> addresses) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userfirstName = userfirstName;
		this.userlastName = userlastName;
		this.usermobile = usermobile;
		this.userEmail = userEmail;
		this.addresses = addresses;
	}

	public User(long userId, String userName, String userPassword, String userfirstName, String userlastName,
			String usermobile, String userEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userfirstName = userfirstName;
		this.userlastName = userlastName;
		this.usermobile = usermobile;
		this.userEmail = userEmail;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserfirstName() {
		return userfirstName;
	}

	public void setUserfirstName(String userfirstName) {
		this.userfirstName = userfirstName;
	}

	public String getUserlastName() {
		return userlastName;
	}

	public void setUserlastName(String userlastName) {
		this.userlastName = userlastName;
	}

	public String getUsermobile() {
		return usermobile;
	}

	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
