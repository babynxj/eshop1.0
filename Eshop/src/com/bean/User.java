package com.bean;

/**
 * 用户信息类
 * @version 1.0.0
 */
public class User {

	/**
	 * 用户账号
	 */
	private String userID;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 性别
	 */
	private String userSex;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 邮寄地址
	 */
	private String address;
	
	/**
	 * 联系方式
	 */
	private String phone;
	
	/**
	 * 电子邮箱
	 */
	private String email;
	
	/**
	 * 注册时间
	 */
	private String regTime;
	
	/**
	 * 邮编
	 */
	private String postcode;
	
	public User(){
		
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	
}
