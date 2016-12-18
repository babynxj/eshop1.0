package com.daoFactory;

import com.dao.UserDao;
import com.daoImpl.UserDaoImpl;
/**
 * 用户信息的DaoFactory类
 * @version 1.0.0
 */
public class UserDaoFactory {

	public UserDao getUserDaoInstance(){
		return new UserDaoImpl();
	}
}
