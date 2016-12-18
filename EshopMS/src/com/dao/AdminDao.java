package com.dao;

import com.bean.Admin;
/**
 * 管理员信息的实体类
 * @version 1.0.0
 */
public interface AdminDao {
	
	/**
	 * 管理员登录验证
	 */
	public boolean checkLogin(String id,String pwd);
	
	/**
	 * 管理员修改密码
	 */
	public boolean changePassword(Admin a);
	
	/**
	 * 通过管理员账号获取管理员个人信息
	 */
	public Admin getManagerInfo(String id);
}
