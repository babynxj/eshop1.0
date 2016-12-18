package com.dao;

import com.bean.User;

/**
 * 用户信息的实体类
 * @version 1.0.0
 */
public interface UserDao {

	/**
	 * 用户注册
	 */
	public boolean register(User u);
	
	/**
	 * 用户登录验证
	 */
	public boolean checkLogin(String id,String pwd);
	
	/**
	 * 通过用户账号获取用户信息
	 */
	public User getUserInfoById(String id);
	
	/**
	 * 判断用户账号是否已经被注册过
	 */
	public boolean isUserIdExist(String id);
}
