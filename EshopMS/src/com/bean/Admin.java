package com.bean;
/**
 * 管理员信息类
 * @version 1.0.0
 */
public class Admin {
	
	/**
	 * 管理员账号
	 */
	private String adminID;
	
	/**
	 * 管理员密码
	 */
	private String password;
	
	/**
	 * 管理员姓名
	 */
	private String name;
	
	public Admin(){
		
	}
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
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
	
}
