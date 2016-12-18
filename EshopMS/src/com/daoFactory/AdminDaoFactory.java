package com.daoFactory;

import com.dao.AdminDao;
import com.daoImpl.AdminDaoImpl;
/**
 * 管理员信息的DaoFactory类
 * @version 1.0.0
 */
public class AdminDaoFactory {
	
	public AdminDao getAdminDaoInstance(){
		return new AdminDaoImpl();
	}
}
