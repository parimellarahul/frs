package com.frs.demo.dto;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="admin")
public class AdminDto {

	@Id
	@Column(name="adminId")
	@NotNull
	private int adminId;
	@Column(name="adminPass")
	@NotNull
	@Size(min=2,message="user name should have atleast 2 characters")
	private String adminPass;
	
	public AdminDto() {
		
	}
	public AdminDto(int adminId, String adminPass) {
		super();
		this.adminId = adminId;
		this.adminPass = adminPass;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
}
	
	
