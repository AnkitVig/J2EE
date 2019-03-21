package com.project.model;

public class UserAccount {
	public UserAccount(String userName, String password, String name,
			String phoneNo, String branch, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.phoneNo = phoneNo;
		this.branch = branch;
		this.role = role;

	}
	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserAccount(String userLogin, String userPass, String role) {
		super();
		this.userName = userLogin;
		this.password = userPass;
		this.role = role;
	}
	
	public UserAccount(String userName, String name, String phoneNo, String branch, String photo) {
		super();
		this.userName = userName;
		this.name = name;
		this.phoneNo = phoneNo;
		this.branch = branch;
		this.photo=photo;
	}

	private String userName;
	private String password;
	private String name;
	private String phoneNo;
private String photo; 
	public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}

	private String branch;
	private String role;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}


}
