package com.petmily.user.model.vo;

public class User {

	private String userId;
	private String password;
	private String userName;
	private String userBirth;
	private String phone;
	private String zipCode;
	private String address;
	private String email;
	private String gender;
	private String status;
	private String userType;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String userId, String password, String userName, String userBirth, String phone, String zipCode,
			String address, String email, String gender, String status, String userType) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.userBirth = userBirth;
		this.phone = phone;
		this.zipCode = zipCode;
		this.address = address;
		this.email = email;
		this.gender = gender;
		this.status = status;
		this.userType = userType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", userName=" + userName + ", userBirth="
				+ userBirth + ", phone=" + phone + ", zipCode=" + zipCode + ", address=" + address + ", email=" + email
				+ ", gender=" + gender + ", status=" + status + ", userType=" + userType + "]";
	}
	
}
