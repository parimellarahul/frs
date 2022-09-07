package com.frs.demo.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name="user_tbl")
public class UserDto {
	@Id
	@Column(name="userId")
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@Column(name="name",nullable=false)
	@NotNull
	
	@Size(min=2,message="user name should have atleast 2 characters")

	private String userName;
	@Column
	@NotEmpty
	@Size(min=8,message="password should have 8 characters")
	private String password;
	@Column
	@NotEmpty
	private String userType;

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDto(int userId, String userName, String userType, String password) {
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