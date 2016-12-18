package com.dao;

import java.util.ArrayList;

import com.bean.User;
/**
 * 用户信息的实体类
 * @version 1.0.0
 */
public interface UserDao {

	/**
	 * 获取所有会员信息
	 */
	public ArrayList<User> getAllInfo();
	
	/**
	 * 通过会员号查找会员信息
	 */
	public User getUserInfoById(String id);
	
	/**
	 * 修改会员信息
	 */
	public boolean updateUserPwd(User u);
	
	/**
	 * 删除会员信息
	 */
	public boolean deleteUserInfo(String id);
}
