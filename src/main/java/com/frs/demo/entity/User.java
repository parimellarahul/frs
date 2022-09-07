package com.frs.demo.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="USER_TBL")
public class User {

	@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@Column(unique = true)
	private String userName;
	@Column(unique = true)
	private String userType;
	private String password;
	public User() {
		
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String userName, String userType, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}